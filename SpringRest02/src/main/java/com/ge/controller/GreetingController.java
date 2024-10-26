package com.ge.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api1")
public class GreetingController {
    @GetMapping("/welcome1")
    public String getResponse1(@RequestParam(value = "name",required = false,defaultValue = "Likhith") String name){
        String body = "Hello! "+ name +" Welcome Back to Spring Classes";
        return body;
    }

    @GetMapping("/welcome2")
    public String getResponse2(@PathVariable(value = "name",required = false) String name){
        String body = "Hello! "+ name +"Welcome Back to Spring REST Classes";
        return body;
    }
}
