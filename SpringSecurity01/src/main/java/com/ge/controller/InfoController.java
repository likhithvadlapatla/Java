package com.ge.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo(HttpServletRequest request){
        return "Happy to launch the course.";
    }

    @GetMapping("/course")
    public String getInfoOnCourse(HttpServletRequest request){
        return "Course is launching this month.";
    }
}
