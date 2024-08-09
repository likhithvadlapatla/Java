package com.ge.controller;

import com.ge.service.IGreetingService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private IGreetingService service;

    @GetMapping("/greeting1")
    public String greeting1(Map<String,Object> map){
        String wish = service.generateGreetings();
        map.put("wish",wish);
        return "greeting1";
    }

    @GetMapping("/greeting2")
    public void greeting2(Map<String,Object> map){
        map.put("wish",service.generateGreetings());
    }

    @GetMapping("/greeting3")
    public Map<String,Object> greeting3(){
        Map<String,Object> map = new HashMap<>();
        map.put("wish",service.generateGreetings());
        return map;
    }

    @GetMapping("/greeting4")
    public void greeting4(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1> Hello " + service.generateGreetings() + "</h1>");
    }
}
