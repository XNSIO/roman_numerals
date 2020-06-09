package com.roman.numeral;

import java.util.HashMap;

public class RomanNumeral {

    private HashMap<Character,Integer> map ;

    public void validate(String numerals){
        if((!numerals.matches("[IVXLCDM]+"))||(numerals.matches("[IXCM]{4}"))||(numerals.matches("[VLD]{2}"))){
            throw new IllegalArgumentException("Invalid Input");
        }
    }

    public RomanNumeral(HashMap<Character,Integer> map) {
        this.map = map;
    }

    public Integer RomanNumeralToDecimal(String numerals) {
        numerals = numerals.replaceAll("\\s", "");
        numerals = numerals.toUpperCase();
        validate(numerals);

        Integer decimalValue = 0;

       char[] numeralsAsChar = numerals.toCharArray();
       int index = 0;
        for (index = 0; index<numeralsAsChar.length-1;index++) {
            if (this.map.get(numeralsAsChar[index])>=this.map.get(numeralsAsChar[index+1])) {
                decimalValue = decimalValue + this.map.get(numeralsAsChar[index]);
            }
            else {
                decimalValue = decimalValue + this.map.get(numeralsAsChar[index+1]) -this.map.get(numeralsAsChar[index]);
                index++;
            }
        }
        if(index==numeralsAsChar.length-1){
            decimalValue = decimalValue + this.map.get(numeralsAsChar[index]);
        }

       return decimalValue;
    }

}
