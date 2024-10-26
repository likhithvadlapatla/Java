package com.ge.rest;

import com.ge.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InfoController {

    public List<Student> students = new ArrayList<>
            (
                    List.of(new Student(1,"Likhith","Java"),
                            new Student(2,"Triveni","Accounts"),
                            new Student(3,"Kiran","Spring Boot"))
            );

    @GetMapping("/get-students")
    public List<Student> getAllStudents(){
        return students;
    }

    @GetMapping("/students")
    public String getInfo(){
        return "This app is all about student";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "Student is added";
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
