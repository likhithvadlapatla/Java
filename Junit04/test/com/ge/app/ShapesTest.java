package com.ge.app;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapesTest {
    Shapes shape=new Shapes();
    @Test
    void testComputeSquareArea(){
        assertEquals(25,shape.computeSquareArea(5));
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(78.5,shape.computeCircleArea(5),"Area of circle calculation is wrong"); /*This message will be displayed only when the test case is failed. The message here is String type. This will get evaluated even if the test case is passed.*/
    }

    @Test
    void testComputeCircleArea_Supplier(){
        /*The method inside the assertEquals is Supplier Interface. It supports functional programming. This will not take any parameters. The body of this method gets evaluated only when the test case is failed.*/
        assertEquals(78.5,shape.computeCircleArea(5),()->"Area of circle calculation is wrong");
    }

    /*assertNotEquals works exactly opposite to assertEquals. If both the expected and the actual results are not matching the test case will pass or else the test case will fail.*/
    @Test
    void testComputeSquareArea_WithMessage(){
        assertNotEquals(25,shape.computeSquareArea(5),"Message to developer if the testcase fails.");
    }

    @Test
    void testComputeSquareArea_Supplier(){
        assertNotEquals(24,shape.computeSquareArea(5),()->"Message to developer if the test case fails.");
    }
}
