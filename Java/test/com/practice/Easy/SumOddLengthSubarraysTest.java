package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumOddLengthSubarraysTest {

    /**
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,4,2,5,3]
     * Output: 58
     * Explanation: The odd-length subarrays of arr and their sums are:
     * [1] = 1
     * [4] = 4
     * [2] = 2
     * [5] = 5
     * [3] = 3
     * [1,4,2] = 7
     * [4,2,5] = 11
     * [2,5,3] = 10
     * [1,4,2,5,3] = 15
     * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
     * Example 2:
     *
     * Input: arr = [1,2]
     * Output: 3
     * Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
     * Example 3:
     *
     * Input: arr = [10,11,12]
     * Output: 66
     */
    @Test
    public void sumOddLengthSubarrays3() {
        SumOddLengthSubarrays sol = new SumOddLengthSubarrays();
        int actual, expected;
        int[] nums;

        nums = new int[]{1,4,2,5,3};
        expected = 58;
        actual = sol.sumOddLengthSubarrays3(nums);
        Assert.assertEquals(expected, actual);


        nums = new int[]{10,11,12};
        expected = 66;
        actual = sol.sumOddLengthSubarrays3(nums);
        Assert.assertEquals(expected, actual);

    }
}