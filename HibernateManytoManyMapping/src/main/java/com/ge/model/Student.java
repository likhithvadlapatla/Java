package com.ge.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Student {

    @Id
    @Column(name="students_id")
    private Integer id;
    private String name;
    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Courses> courses;

    public Student(){
        System.out.println("Zero Parameterized Constructor of Student.");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }
}
