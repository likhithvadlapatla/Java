package com.ge.controller;

import com.ge.model.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @GetMapping("/getcourse/{id}")
    public ResponseEntity<Course> getCourseDetails(@PathVariable("id") Integer id){
        Course course = new Course(1,"Spring Boot",9000.0);

        /*
        WebMvcLinkBuilder.linkTo(...):
        This method is part of the Spring HATEOAS library. It helps you create links to specific controller methods.

        WebMvcLinkBuilder.methodOn(CourseRestController.class):
        This line creates a "proxy" instance of the CourseRestController class.
        The methodOn call does not invoke the method but rather uses reflection to inspect the method’s metadata. This includes:
        The HTTP method (GET, POST, etc.) associated with the method.
        The URL path specified by annotations on the method.

        .getCourseJava():
        Here, you're calling the getCourseJava() method on the proxy instance.
        This tells Spring which method of the CourseRestController you want to create a link to.

        .withRel("getjava"):
        The withRel method is used to specify the relationship of the link.
        The string "getjava" is a custom relation name that describes the purpose of the link.
         */

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
                .getCourseJava()).withRel("getjava");

        course.add(link);
        return new ResponseEntity<Course>(course,HttpStatus.OK);
    }

    @GetMapping("/getallcourses")
    public List<Course> getCourseDetails(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "SBM", 9999.9));
        courses.add(new Course(2, "React", 8888.9));
        courses.add(new Course(3, "DevOps with AWS", 9999.9));
        return courses;
    }

    @GetMapping("/getjava")
    public List<Course> getCourseJava(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(2,"Java",999.9));
        return courses;
    }

    @GetMapping("/getthread/{id}")
    public ResponseEntity<Course> getJavaCourse(@PathVariable("id") Integer id) {
        Course course = new Course(1, "Spring Boot", 9000.0);

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
                .getCourseDetails(1)).withRel("getcourse");

        course.add(link);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

}
