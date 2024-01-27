package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPushesTest {

    @Test
    void minimumPushes() {
        MinimumPushes sol = new MinimumPushes();
        int actual, expected;
        String word = null;
//        word = "xycdefghij";
//        actual = sol.minimumPushes(word);
//        expected = 12;
//        assertEquals(expected, actual);
//
//        word = "abcde";
//        actual = sol.minimumPushes(word);
//        expected = 5;
//        assertEquals(expected, actual);
//
//        word = "aaabcde";
//        actual = sol.minimumPushes(word);
//        expected = 7;
//        assertEquals(expected, actual);
//
//
//        word = "aaabbbbbcde";
//        actual = sol.minimumPushes(word);
//        expected = 11;
//        assertEquals(expected, actual);


//        word = "aabbccddeeffgghhi";
//        actual = sol.minimumPushes(word);
//        expected = 18;
//        assertEquals(expected, actual);
//
//        word = "aaabbccddeeffgghhi";
//        actual = sol.minimumPushes(word);
//        expected = 19;
//        assertEquals(expected, actual);
//

        word = "aaabbccddeeffgghhiijjkkllmmnnooppx"; // 2* 7 + 3  + 2*2 * 8 + 3 = 52
        actual = sol.minimumPushes(word);
        expected = 52;
        assertEquals(expected, actual);

    }
}