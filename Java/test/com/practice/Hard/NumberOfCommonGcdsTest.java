package com.practice.Hard;

import com.practice.Easy.Hard.NumberOfCommonGcds;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfCommonGcdsTest {

    @Test
    public void countDifferentSubsequenceGCDs() {

        NumberOfCommonGcds sol = new NumberOfCommonGcds();
        int expected, actual;
        int[] nums = new int[] {6, 10, 3};
        expected = 5;
        actual = sol.countDifferentSubsequenceGCDs(nums);
        Assert.assertEquals(expected, actual);
    }
}