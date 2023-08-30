package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinSumOfSubArrayTest {

    @Test
    public void smallestSumSubarr() {

        MinSumOfSubArray sol = new MinSumOfSubArray();

        int[] arr;
        int expected, actual;


        arr = new int[]{3, -4, 2, -3, -1, 7, -5};
        expected =-6;
        actual = sol.smallestSumSubarr(arr);
        Assert.assertEquals(expected, actual);

        arr = new int[]{2, 6, 8, 1, 4};
        expected =1;
        actual = sol.smallestSumSubarr(arr);
        Assert.assertEquals(expected, actual);;
    }
}