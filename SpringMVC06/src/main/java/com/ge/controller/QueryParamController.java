package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class QueryParamController {

    /*The values for n and course will be passed from end of the URL*/
    /*This is how you send the values from URL : http://localhost:8086/get?name=Likhith&course=SpringMVC*/
    /*@RequestParam annotation is used if there is name mismatch between the variable in the url and the variable declared in the method definition. In this annotation you pass the variable name you have used in the URL inside double quotes.*/
    @GetMapping("/get")
    public String generateMessage(@RequestParam("name") String n, String course, Map<String, Object> map){
        String message = "Hey There! "+n+" , I hope you are learning "+course;
        map.put("message",message);
        return "index";
    }
}
