package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PathParamController {

    /*The values for n and course will be passed from anywhere in the URL*/
    /*This is how you send the values from URL : http://localhost:8086/get/Likhith/Spring MVC*/
    /*@PathVariable annotation should be used before the variables in the method definition.*/
    /*You need to mention the order of variables that you enter in the URL inside the the GetMapping annotation.*/
    @GetMapping("/get/{name}/{course}")
    public String generateMessage(@PathVariable("name") String n, @PathVariable("course") String course, Map<String, Object> map){
        String message = "Hey There! "+n+" , I hope you are learning "+course;
        map.put("message",message);
        return "index";
    }
}
