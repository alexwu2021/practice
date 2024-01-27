package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDivScoreTest {

    @Test
    void test_maxDivScore() {
        MaxDivScore sol = new MaxDivScore();

        int[] nums = {56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78};
        int[] divisors = {39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10,33,72,97,60,79,68,25,63};

        int actual = sol.maxDivScore(nums, divisors);
        int expected = 7;
        assertEquals(expected, actual);
    }


    @Test
    void test_maxDivScore2() {
        MaxDivScore sol = new MaxDivScore();

        int[] nums = {73,13,20,6};
        int[] divisors = {56,75,83,26,24,53,56,61};

        int actual = sol.maxDivScore(nums, divisors);
        int expected = 24;
        assertEquals(expected, actual);
    }

//
}