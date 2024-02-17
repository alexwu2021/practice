package com.practice.Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitArraySameAverageTest {

    @Test
    void splitArraySameAverage() {
        int[] nums = {1,2,3,4,5,6,7,8};
        SplitArraySameAverage sol = new SplitArraySameAverage();
        boolean actual = sol.splitArraySameAverage(nums);
        boolean expected = true;
        assertEquals(expected, actual);
    }
}