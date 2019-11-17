package com.cbt.utilities;

public class StringUtility {
    public static String verfiyEquals(String expected, String actual){
                 String result="";
        if(expected.equalsIgnoreCase(actual)){
            result= "PASS";
        } else{
            result="FAIL \nExpected result= "+expected+"\nActual result= "+actual;

        }
        return result;

    }
}
