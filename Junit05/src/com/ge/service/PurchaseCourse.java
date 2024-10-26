package com.ge.service;

import com.ge.model.Course;

public class PurchaseCourse {

    public boolean proceedWithCourse(Course course){
        return course.coursePurchased();
    }
}
