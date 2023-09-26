package com.practice.Hard;

import com.practice.Easy.Hard.MinimumOperationsToMakeASubsequence;
import org.junit.Assert;
import org.junit.Test;

public class MinimumOperationsToMakeASubsequenceTest {

    @Test
    public void minOperations() {

        MinimumOperationsToMakeASubsequence sol = new MinimumOperationsToMakeASubsequence();
        int [] target, arr;
        int actual, expected;
//        target = new int[]{5, 1, 3};
//        arr = new int[]{9, 4, 2, 3, 4};
//        expected = 2;
//        actual = sol.minOperations(target, arr);
//        Assert.assertEquals(expected, actual);

        target = new int[]{6,4,8,1,3,2};
        arr = new int[]{9, 4, 2, 3, 4};
        expected = 3;
        actual = sol.minOperations(target, arr);
        Assert.assertEquals(expected, actual);



    }
}