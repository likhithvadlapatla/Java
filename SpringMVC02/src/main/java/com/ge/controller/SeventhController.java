package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller3")
public class SeventhController{

    /*If you use Model model as a parameter in the method spring will directly create the object for it.*/
    @PostMapping("/welcome5")
    public String display(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("message","Welcome to seventh web application. You are displayed because of Post Request Mapping.");
        return "home";
    }

    @GetMapping("/welcome5")
    public String displayMessage(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("message","Welcome to seventh web application. You are displayed because of Get Request Mapping.");
        return "home";
    }
}
