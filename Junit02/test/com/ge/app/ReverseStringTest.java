package com.ge.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {
    @Test
    public void test(){
        ReverseString reverse = new ReverseString();
        assertEquals("avaJ",reverse.reverseString("Java"));
        assertEquals("neilA",reverse.reverseString("Alien"));
    }
}
