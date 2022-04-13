package com.order.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.order.dao.ProductDao;
import com.order.entities.Category;
import com.order.entities.Product;
import com.order.entities.User;
import com.order.repositores.ProductRepo;
import com.order.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductDao productDao;

    @GetMapping
    public ResponseEntity findAll() {
        int code;
        Gson gson = new GsonBuilder().create();
        List<Product> rs = productRepo.findAll();
        String st = gson.toJson(rs, List.class);
        return new ResponseEntity<>(st, HttpStatus.OK);

    }

    @GetMapping(value = "/id/{product_id}")
    public ResponseEntity findById(@PathVariable("product_id") int id) {
        Gson gson = new GsonBuilder().create();
        Product ls = productDao.findById(id);
        String s = gson.toJson(ls, Product.class);
        return new ResponseEntity<>(s, HttpStatus.OK);

    }

    @GetMapping(value = "/idCategory/{category_id}")
    public ResponseEntity findByCategory(@PathVariable("category_id") int id) {
        Gson gson = new GsonBuilder().create();
        List<Product> ls = productDao.findProductByCategory(id);
        String s = gson.toJson(ls, List.class);
        return new ResponseEntity<>(s, HttpStatus.OK);

    }

//
}
