package com.order.controller;

import com.order.entities.Category;
import com.order.entities.User;
import com.order.repositores.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryRepo.save(category);
        return "redirect:/";
    }


    @RequestMapping("/getListCategory")
    public String listCategory(Model model) {
        List<Category> listCategory = categoryRepo.findAll();
        model.addAttribute("listProducts", listCategory);

        return "listCategory";
    }

}
