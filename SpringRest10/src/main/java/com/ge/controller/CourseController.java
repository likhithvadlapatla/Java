package com.ge.controller;

import com.ge.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @PostMapping(value="/addcourse",consumes={"application/xml","application/json"})
    public ResponseEntity<String> addCourseDetails(@RequestBody Course course){
        System.out.println(course);
        String message = "Course details added into database.";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getcourse",produces = {"application/xml","application/json"})
    public Course getCourseDetails(){
        Course course = new Course(1,"Java",999.9);
        return course;
    }
}
