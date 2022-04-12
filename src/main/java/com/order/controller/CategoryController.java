package com.order.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.order.dao.CategoryDao;
import com.order.entities.Category;
import com.order.entities.User;
import com.order.repositores.CategoryRepo;
import com.order.response.Response;
import com.order.server.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryDao categoryDao;


    @GetMapping
    public ResponseEntity findAll() {
        int code;
        Gson gson = new GsonBuilder().create();
        List<Category> rs = categoryRepo.findAll();
        String st = gson.toJson(rs, List.class);
        return new ResponseEntity<>(st, HttpStatus.OK);

    }


    @GetMapping(value = "/id/{category_id}")
    public ResponseEntity findById(@PathVariable("category_id") int id) {
        Gson gson = new GsonBuilder().create();
        Category ls = categoryDao.findById(id);
        String s = gson.toJson(ls, Category.class);
        return new ResponseEntity<>(s, HttpStatus.OK);

    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> create(@RequestBody Category category) {
        int code;
        Gson gson = new GsonBuilder().create();

        Boolean rs = categoryDao.create(category);
        String st = gson.toJson(rs, Boolean.class);
        return new ResponseEntity<>(st, HttpStatus.OK);

    }


}
