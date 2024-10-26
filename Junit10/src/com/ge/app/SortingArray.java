package com.ge.app;

import java.util.Arrays;
import java.util.Scanner;

public class SortingArray
{
    public int[] sortingArray(int[] array)
    {
        for(int i=0;i<1000000;i++){
            Arrays.sort(array);
        }
        return array;
    }
}
