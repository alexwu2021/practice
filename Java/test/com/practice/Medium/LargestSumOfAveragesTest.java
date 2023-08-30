package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

public class LargestSumOfAveragesTest {

    @Test
    public void largestSumOfAverages() {

        LargestSumOfAverages sol = new LargestSumOfAverages();
        int [] nums = new int[]{1,2,3,4,5,6,7};
        int k = 4;
        double actual, expected;
        expected = 20.5;
        actual = sol.largestSumOfAverages(nums, k);
        Assert.assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));



        nums = new int []{4,1,7,5,6,2,3};
        k = 4;
        expected = 18.16667;
        actual = sol.largestSumOfAverages(nums, k);
        Assert.assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));

    }
}