//package com.order.controller;
//
//import com.order.entities.Category;
//import com.order.entities.Product;
//import com.order.entities.User;
//import com.order.repositores.ProductRepo;
//import com.order.server.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@RestController
//public class ProductController {
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Autowired
//    private ProductService productService;
//
//    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
//    public String saveProduct(@ModelAttribute("category") Product product) {
//        productRepo.save(product);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/getListProduct")
//    public String listCategory(Model model) {
//        List<Product> listProduct = productRepo.findAll();
//        model.addAttribute("listProduct", listProduct);
//
//        return "listProduct";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable(name = "id") int id) {
//        productService.delete(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditProduct(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edit_product");
//        Product product = productRepo.getById(id);
//        mav.addObject("product", product);
//        return mav;
//    }
//}
