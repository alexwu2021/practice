package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsectiveSubsequenceTest {

    @Test
    public void longestConsecutive() {
        LongestConsectiveSubsequence sol = new LongestConsectiveSubsequence();
        int[] nums;
        int actual, expected;
        nums = new int[]{1,2,0,1};
        actual =sol.longestConsecutive(nums);
        expected = 3;
        Assert.assertEquals(expected, actual);
    }
}