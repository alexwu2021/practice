package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Palindrome4Test {

    @Test
    void makePalindrome() {
        Palindrome4 sol = new Palindrome4();
        String input;
        boolean expected, actual;

        input = "abcdba";
        expected = true;
        actual = sol.makePalindrome(input);
        assertEquals(expected, actual);
    }
}