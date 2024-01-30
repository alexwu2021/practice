package com.practice.Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarrayWithConstraintsTest {

    @Test
    void longestAlternatingSubarray() {
        SubarrayWithConstraints sol = new SubarrayWithConstraints();
        int k, actual, expected;
        int[] nums;

        nums = new int[]{3, 2, 5, 8, 9, 4};
        k = 9;

        actual = sol.longestAlternatingSubarray(nums, k);
        expected = 5;
        assertEquals(expected, actual);

        nums = new int[]{3,2,5,4};
        k = 5;

        actual = sol.longestAlternatingSubarray(nums, k);
        expected = 3;
        assertEquals(expected, actual);
    }
}