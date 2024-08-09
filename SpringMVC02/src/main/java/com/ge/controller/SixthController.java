package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SixthController{

    /*If you use Model model as a parameter in the method spring will directly create the object for it.*/
    @PostMapping("/welcome4")
    public String display(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("message","Welcome to sixth web application.");
        return "home";
    }
}
