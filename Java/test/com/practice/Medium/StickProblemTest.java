package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickProblemTest {

    StickProblemRevised sol = new StickProblemRevised();
    @Test
    void testFindMinNumOfSticksToMakeTheNumber_testCase1() {
        int K = 13;
        int[] Sticks = {1, 5, 12};
        int expected = 2;
        int actual = sol.findMinNumOfSticksToMakeTheNumber(Sticks, K);
        assertEquals(expected, actual);
    }

    @Test
    void testFindMinNumOfSticksToMakeTheNumber_testCase2() {
        int K = 68;
        int[] Sticks = {1,14,30,17};
        int expected = 4;
        int actual = sol.findMinNumOfSticksToMakeTheNumber(Sticks, K);
        assertEquals(expected, actual);
    }
    @Test
    void testFindMinNumOfSticksToMakeTheNumber_testCase3() {
        int K = 109;
        int[] Sticks = {13,17,43,100,110,120};
        int expected = -1;
        int actual = sol.findMinNumOfSticksToMakeTheNumber(Sticks, K);
        assertEquals(expected, actual);
    }

}