package com.ge.service;

import com.ge.model.JavaCourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseCourseTest {
    PurchaseCourse course = new PurchaseCourse();
    @Test
    void testAssertTrue(){
        boolean status = course.proceedWithCourse(new JavaCourse());
        assertTrue(status); /*The test case will pass if the value inside the assertTrue method is true else it fails.*/
    }

    @Test
    void testAssertFalse(){
        boolean status = course.proceedWithCourse(new JavaCourse());
        assertFalse(status); /*The test case will pass if the value inside the assertFalse method is false else it fails.*/
    }


}
