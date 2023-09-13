package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedSubstringPatternTest {

    @Test
    void repeatedSubstringPattern() {
        RepeatedSubstringPattern sol = new RepeatedSubstringPattern();
        boolean  actual;
        String input = "abcdab";

        input = "abcdabcd";
        actual = sol.repeatedSubstringPattern(input);
        assertTrue(actual);

        input = "abcdab";
        actual = sol.repeatedSubstringPattern(input);
        assertFalse(actual);

        input = "abcdabcf";
        actual = sol.repeatedSubstringPattern(input);
        assertFalse(actual);


//                  "abacab" +
//                  "abacab";
        input = "abacababacab";
        actual = sol.repeatedSubstringPattern(input);
        assertTrue(actual);


//        "abacababacababacab"
        input = "abacababacababacab";
        actual = sol.repeatedSubstringPattern(input);
        assertTrue(actual);



    }
}