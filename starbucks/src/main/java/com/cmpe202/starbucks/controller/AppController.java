package com.cmpe202.starbucks.controller;

import com.cmpe202.starbucks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class AppController {


    private final UserService userService;

    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value={"/login"})
    public String getLoginPage(Model model){ return "login"; }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(Model model){return "registration";}

    @GetMapping(value={"/","/index","/home"})
    public String getHomePage(Model model)
    {
        model.addAttribute("user", userService.getCurrentUserDto());
        return "index";
    }

    @GetMapping(value="/logout-success")
    public String getLogoutPage(Model model){

        return "logout";
    }

    @GetMapping(value="/menu")
    public String getMenuPage(Model model){
        model.addAttribute("user", userService.getCurrentUserDto());
        return "menu";
    }

    @GetMapping(value="/card")
    public String getCardPage(Model model){
        model.addAttribute("user", userService.getCurrentUserDto());
        return "myCard";
    }

    @GetMapping(value="/card/add")
    public String getAddCardPage(Model model){
        model.addAttribute("user", userService.getCurrentUserDto());
        return "addCard";
    }

    @GetMapping(value="/cart")
    public String getCartPage(Model model){
        model.addAttribute("user", userService.getCurrentUserDto());
        return "cart";
    }

    @GetMapping(value="/item")
    public String getItemPage(Model model){
        model.addAttribute("user", userService.getCurrentUserDto());
        return "item";
    }
}
