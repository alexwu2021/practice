package com.practice.Easy;

import com.practice.Medium.ReverseString2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseString2Test {

    @Test
    void reverseStr() {
        ReverseString2 sol = new ReverseString2();
        String s = "abcdefg";
        int k = 2;
        String actual, expected = "bacdfeg";
        actual = sol.reverseStr(s, k);
        assertEquals(expected, actual);
    }

    @Test
    void reverseStr2() {
        ReverseString2 sol = new ReverseString2();
        String s = "abcd";
        int k = 2;
        String actual, expected = "bacd";
        actual = sol.reverseStr(s, k);
        assertEquals(expected, actual);
    }

    @Test
    void reverseStr3() {
        ReverseString2 sol = new ReverseString2();
        String s = "abcdefgh";
        int k = 2;
        String actual, expected = "bacdfegh";
        actual = sol.reverseStr(s, k);
        assertEquals(expected, actual);
    }
}