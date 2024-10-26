package com.ge.app;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingArrayTest {

    /*This @RepeatedTest annotation runs the test method for number of times that you specify inside the annotation.*/
    @RepeatedTest(3)
    /*You can check the information of the repetitions using implemented methods of RepetitionInfo interface.*/
    void testSortingArray(RepetitionInfo info){
        SortingArray array=new SortingArray();
        int unsorted[]={2,5,1};
        if(info.getCurrentRepetition()==1){
            assertTimeout(Duration.ofMillis(100),() -> array.sortingArray(unsorted));
        }
        else if(info.getCurrentRepetition()==2){
            assertTimeout(Duration.ofMillis(50),() -> array.sortingArray(unsorted));
        }
        else{
            assertTimeout(Duration.ofMillis(10),() -> array.sortingArray(unsorted));
        }
    }
}
