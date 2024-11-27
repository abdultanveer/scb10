package com.example.scb10;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
Calculator calculator;
    public void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    public void tearDown() throws Exception {
    }

    public void testAdd() {
        int expected = 40;
        int actual = calculator.add(10,20);
        assertEquals(expected,actual);
       // assertFalse();
    }
}