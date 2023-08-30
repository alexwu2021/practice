package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ShortestUnsortedContinuousSubarrayTest {

    @Test
    public void findUnsortedSubarray() {
        ShortestUnsortedContinuousSubarray sol = new ShortestUnsortedContinuousSubarray();
        int[] nums = null;
        int actual, expected;

//        Input: nums = [2,6,4,8,10,9,15]
//        Output: 5
//        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//        nums = new int []{2,6,4,8,10,9,15};
//        expected = 5;
//        actual = sol.findUnsortedSubarray_simplified(nums);
//        System.out.println("actual: " + actual);
//        Assert.assertEquals(expected, actual);
//
////        Input: nums = [1,2,3,4]
////        Output: 0
////        Example 3:
//        nums = new int []{1, 2, 3, 4};
//        expected = 0;
//        actual = sol.findUnsortedSubarray(nums);
//        Assert.assertEquals(expected, actual);
//
//
//
////        Input: nums = [1]
////        Output: 0
//        nums = new int []{1};
//        expected = 0;
//        actual = sol.findUnsortedSubarray(nums);
//        Assert.assertEquals(expected, actual);
//
//
////        [1,2,3,3,3]
//        nums = new int []{1,2,3,3,3};
//        expected = 0;
//        actual = sol.findUnsortedSubarray(nums);
//        Assert.assertEquals(expected, actual);
//
//
////          [1,3,2, 2, 2]
//        nums = new int []{1,3,2,2,2};
//        expected = 4;
//        actual = sol.findUnsortedSubarray(nums);
//        Assert.assertEquals(expected, actual);
//
//
        Random random = new Random();
        for(int i=0; i<1; ++i){
            StringBuffer sb = new StringBuffer();
            int size = random.nextInt(10) + 3;
            nums = new int[size];
            for(int j=0; j<size; ++j){
                nums[j] = random.nextInt(30);
                sb.append(nums[j] + ",");
            }
            int actual1 = sol.findUnsortedSubarray(nums);
            int actual2 = sol.findUnsortedSubarray_simplified(nums);
            System.out.println(String.format("nums = [" + sb.toString()+"], ans1 = %d, ans2=%d", actual1, actual2));;
            Assert.assertEquals(actual1, actual2);
        }

    }
}