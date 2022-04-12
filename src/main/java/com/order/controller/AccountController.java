//package com.order.controller;
//
//
//import com.order.entities.Account;
//import com.order.entities.User;
//import com.order.repositores.AccountRepo;
//import com.order.server.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//public class AccountController {
//    @Autowired
//    private AccountRepo accountRepo;
//
//    @Autowired
//    private AccountService accountService;
//
//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
//    public String createAccount(@ModelAttribute("account") Account account) {
//        accountService.create(account);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteAccount(@PathVariable(name = "id") int id) {
//        accountService.delete(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditUser(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edit_user");
//        Account account = accountService.get(id);
//        mav.addObject("user", account);
//        return mav;
//    }
//}
