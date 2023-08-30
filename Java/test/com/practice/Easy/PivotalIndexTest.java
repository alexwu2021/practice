package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PivotalIndexTest {

    @Test
    public void pivotIndex() {
        PivotalIndex sol = new PivotalIndex();
        int [] nums;
        int actual, expected;

        //        Input: nums = [1,7,3,6,5,6]
        //        Output: 3
        //        Explanation:
        //        The pivot index is 3.
        //        Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        //        Right sum = nums[4] + nums[5] = 5 + 6 = 11
        nums = new int[]{1,7,3,6,5,6};
        expected = 3;
        actual = sol.pivotIndex(nums);
        Assert.assertEquals(expected, actual);

        //        Input: nums = [1,2,3]
        //        Output: -1
        //        Explanation:
        //        There is no index that satisfies the conditions in the problem statement.
        nums = new int[]{1,2, 3};
        expected = -1;
        actual = sol.pivotIndex(nums);
        Assert.assertEquals(expected, actual);

        //        Input: nums = [2,1,-1]
        //        Output: 0
        //        Explanation:
        //        The pivot index is 0.
        //        Left sum = 0 (no elements to the left of index 0)
        //        Right sum = nums[1] + nums[2] = 1 + -1 = 0
        nums = new int[]{2, 1, -1};
        expected = 0;
        actual = sol.pivotIndex(nums);
        Assert.assertEquals(expected, actual);


        nums = new int[]{-1,-1,-1,0,1,1};
        expected = 0;
        actual = sol.pivotIndex(nums);
        Assert.assertEquals(expected, actual);

    }
}