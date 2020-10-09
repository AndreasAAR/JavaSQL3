package com.lynda.javatraining.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    public static String getInput(String prompt){
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(prompt);
        System.out.println("Flush");
        try{
            return stdin.readLine();
        } catch (IOException e) {
           return "ERROR"  + e.getMessage();
        }
    }

    public static double getDoubleInput(String promt) throws NumberFormatException{
        String input = getInput(promt);
        return Double.parseDouble(input);
    }

}
