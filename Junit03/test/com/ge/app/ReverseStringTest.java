package com.ge.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

    ReverseString reverse = new ReverseString();
    @Test
    public void testReverseString_OneWord(){
        assertEquals("avaJ",reverse.reverseString("Java"));
        assertEquals("neilA",reverse.reverseString("Alien"));
    }

    @Test
    public void testReverseString_MultipleWords(){
        assertEquals("egaugnaL avaJ",reverse.reverseString("Java Language"));
    }
}
