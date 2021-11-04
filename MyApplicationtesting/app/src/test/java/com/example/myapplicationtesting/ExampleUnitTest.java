package com.example.myapplicationtesting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int id = 0;
        String stringProfile = "1 01 not_started\n1 02 not_started\n1 03 not_started";

        // split it once by space
        String[] parts = stringProfile.split("\n");

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

        for(int i =0; i < results.length; i++){
            System.out.println(Arrays.toString(new String[]{results[i][2]}));
        }

        for (int i=0; i<results.length; i++){
            id = id + 1;
        }
        System.out.println(id);

        // then print the result

    }
}