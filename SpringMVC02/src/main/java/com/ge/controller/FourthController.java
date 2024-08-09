package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*To access the web file returned by this controller you need to use http://localhost:8086/controller2/welcome3*/
@RequestMapping("controller2")
public class FourthController{

    /*If you use Model model as a parameter in the method spring will directly create the object for it.*/
    @GetMapping("/welcome3")
    public String display(Model model){
        System.out.println(model.getClass().getName());
        model.addAttribute("message","Welcome to fourth web application.");
        return "home";
    }
}
