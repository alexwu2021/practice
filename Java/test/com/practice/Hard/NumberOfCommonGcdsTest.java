package com.practice.Hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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