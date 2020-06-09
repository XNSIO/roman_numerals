package com.roman.numeral;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralTest {

    private final HashMap<Character,Integer> map = new HashMap<Character,Integer>() {
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };
    private final RomanNumeral romanNumeral = new RomanNumeral(map);

    @Test
    public void testcorrectOutput() {
        assertEquals(100,romanNumeral.RomanNumeralToDecimal("C"));
    }

    @Test
    public void testwhiteSpace() {
        assertEquals(40,romanNumeral.RomanNumeralToDecimal("X  L"));
    }

    @Test
    public void testLowerCase() {
        assertEquals(97,romanNumeral.RomanNumeralToDecimal("xcvii"));
    }

    @Test
    public void testInvalidInput() {
        try{
            romanNumeral.RomanNumeralToDecimal("2cji");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Input",e.getMessage());
        }
    }

    @Test
    public void testEmptyString() {
        try{
            romanNumeral.RomanNumeralToDecimal("");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Input",e.getMessage());
        }
    }

    @Test
    public void testMorethan4I() {
        try{
            romanNumeral.RomanNumeralToDecimal("iI iii");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Input",e.getMessage());
        }
    }

    @Test
    public void testMorethan1VorL() {
        try{
            romanNumeral.RomanNumeralToDecimal("Xcvvll");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Input",e.getMessage());
        }
    }
}