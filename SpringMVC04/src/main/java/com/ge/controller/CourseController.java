package com.ge.controller;

import com.ge.service.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class CourseController {

    @GetMapping("/course1")
    public String getCourseInfo1(Model model){
        Course course = new Course(1,"Devops",5000.00);
        model.addAttribute("course",course);
        return "course";
    }

    /*We are creating and passing the values to the parameters without using POJO.(Hard coding)*/
    @GetMapping("/course2")
    public String getCourseInfo2(Map<String, Object> map){
        map.put("cid",2);
        map.put("cname","Java");
        map.put("price",6000.00);
        return "courseinfo";
    }
}
