package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumEqualsKTest {

    @Test
    public void subarraySum() {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int[]nums;
        int k;

        nums = new int[] {1, 1, 1};
        k = 2;
        int res = subArraySumEqualsK.subarraySum(nums, k);
        assert (res == 2);
    }
}