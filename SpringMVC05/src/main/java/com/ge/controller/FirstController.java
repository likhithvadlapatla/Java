package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FirstController{

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/response")
    public String showSomeResponse(Map<String,Object> map){
        String[] booksName = new String[] {"Java","Junit5","Spring Boot"};
        map.put("books", booksName);
        return "response";
    }

}
