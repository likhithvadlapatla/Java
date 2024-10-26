package com.ge.app;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class SortingArraysTest {
    SortingArray array = new SortingArray();
    @Test
    void testSortingArray_Exception1(){
        try{
            int unsorted[] = {2,5,3};
            int sortedArray[] = array.sortingArray(unsorted);
            for(int element:sortedArray){
                System.out.println(element);
            }
            System.out.println("Statements below exception.");
            fail();
        }
        catch(NullPointerException e){
            System.out.println();
        }
    }

    @Test
    void testSortingArray_Exception2(){
        int unsorted[]=null;
        assertThrows(NullPointerException.class,()->array.sortingArray(unsorted)); /*Here we are using supplier interface(lambda expression) because the execution of this function will be done when assertThrows executes it. If we don't use lambda expression and directly call it, it will execute even before the assertThrows gets a chance to check for the exception, and it may result to test failure.*/
    }
}
