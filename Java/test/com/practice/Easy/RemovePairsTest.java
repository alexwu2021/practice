package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemovePairsTest {

    RemovePairs sol = new RemovePairs();
    @Test
    void remove_case1() {
        String input = "01010";
        int actual, expected;
        expected = 1;
        actual = sol.remove(input);
        assertEquals(expected, actual);
    }

    @Test
    void remove_case2() {
        String input = "111000";
        int actual, expected;
        expected = 0;
        actual = sol.remove(input);
        assertEquals(expected, actual);
    }

    @Test
    void remove_case3() {
        String input = "111*000";
        int actual, expected;
        expected = input.length();
        actual = sol.remove(input);
        assertEquals(expected, actual);
    }

    @Test
    void remove_case4() {
        String input = "11*1000";
        int actual, expected;
        expected = input.length() - 2;
        actual = sol.remove(input);
        assertEquals(expected, actual);
    }
}