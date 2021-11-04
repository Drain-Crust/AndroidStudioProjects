package com.example.myapplicationtesting;

import java.util.Arrays;

public class testing {
    public static void main(String[] args) {
        String stringProfile = "1 01 not_started\r1 02 not_started\r1 03 not_started";

        // split it once by space
        String[] parts = stringProfile.split("\r");

        // create some result array with the amount of double pairs as its dimension
        String[][] results = new String[parts.length][];

        // iterate over the result of the first splitting
        for (int i = 0; i < parts.length; i++) {
            // split each one again, this time by comma
            String[] values = parts[i].split(" ");

            // create two doubles out of the single Strings
            String a = values[0];
            String b = values[1];
            String c = values[2];

            // add them to an array
            String[] value = {a, b, c};

            // add the array to the array of arrays
            results[i] = value;
        }

        // then print the result
        for (String[] pair : results) {
            System.out.printf("%h and %h and %h%n", pair[0], pair[1], pair[2]);
        }
    }
}
