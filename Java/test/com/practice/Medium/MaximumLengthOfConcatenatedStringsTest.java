package com.practice.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumLengthOfConcatenatedStringsTest {

    @Test
    void maxLength() {
        MaximumLengthOfConcatenatedStrings sol = new MaximumLengthOfConcatenatedStrings();
        int actual, expected;
        List<String> arr = new ArrayList<>();

//        expected = 4;
//        arr.clear();
//        arr.add("un");
//        arr.add("iq");
//        arr.add("ue");
//        actual = sol.maxLength(arr);
//        assertEquals(expected, actual);
//
//        expected = 6;
//        arr.clear();
//        arr.add("cha");
//        arr.add("r");
//        arr.add("act");
//        arr.add("ers");
//        actual = sol.maxLength(arr);
//        assertEquals(expected, actual);
//
//        expected = 0;
//        arr.clear();
//        arr.add("aa");
//        arr.add("bb");
//        actual = sol.maxLength(arr);
//        assertEquals(0, actual);
//
//
//        arr.clear();
//        arr.add("abcdefghijklmnopqrstuvwxyz");
//        actual = sol.maxLength(arr);
//        expected = 26;
//        assertEquals(expected, actual);
//
//        arr.clear();
//        arr.add("a");
//        arr.add("b");
//        actual = sol.maxLength(arr);
//        expected = 2;
//        assertEquals(expected, actual);


        arr.clear();
        arr.add("a");
        arr.add("abc");
        arr.add("d");
        arr.add("de");
        arr.add("def");

        actual = sol.maxLength(arr);
        expected = 6;
        assertEquals(expected, actual);



    }
}