package com.celloud.utils;

public class PrintUtils {
    private static boolean canPrint = false;

    public static void println(String message) {
        if(canPrint){
            System.out.println(message);
        }
        
    }

}
