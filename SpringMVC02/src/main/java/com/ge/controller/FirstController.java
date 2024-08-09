package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @RequestMapping("/welcome1")
    public ModelAndView display(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Hello! Welcome to first web application.");
        mav.setViewName("index");
        return mav;
    }
}
