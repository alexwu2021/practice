package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindMissingRangesTest {

    @Test
    public void findMissingRanges() {
        FindMissingRanges sol = new FindMissingRanges();
        int[] nums;
        int lower, upper;
        List<String> actual, expected, actual_ref;

//
//        Input: nums = [0,1,3,50,75], lower = 0, upper = 99
//        Output: ["2","4->49","51->74","76->99"]
//        Explanation: The ranges are:
//[2,2] --> "2"
//                [4,49] --> "4->49"
//                [51,74] --> "51->74"
//                [76,99] --> "76->99"
//
        nums = new int[]{0,1,3,50,75};
        lower = 0;
        upper = 99;
        expected = new ArrayList<>();
        expected.add("2");
        expected.add("4->49");
        expected.add("51->74");
        expected.add("76->99");
        actual = sol.findMissingRanges(nums, lower, upper);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));


        nums = new int[]{-1};
        lower = -2;
        upper = -1;
        expected = new ArrayList<>();
        expected.add("-2");
        actual = sol.findMissingRanges(nums, lower, upper);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));


        nums = new int[]{1};
        lower = -1;
        upper = 100000;
        expected = new ArrayList<>();
        expected.add("-1->0");
        expected.add("2->100000");
        actual = sol.findMissingRanges(nums, lower, upper);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));


        nums = new int[]{-1};
        lower = -2;
        upper = 0;
        expected = new ArrayList<>();
        expected.add("-2");
        expected.add("0");
        actual = sol.findMissingRanges(nums, lower, upper);
        //actual_ref = sol.findMissingRanges_mcopy(nums, lower, upper);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));



        nums = new int[]{0};
        lower = 0;
        upper = 9;
        expected = new ArrayList<>();
        expected.add("1->9");
        actual = sol.findMissingRanges(nums, lower, upper);
        //actual_ref = sol.findMissingRanges_mcopy(nums, lower, upper);
        Assert.assertArrayEquals(expected.toArray(new String[expected.size()]), actual.toArray(new String[actual.size()]));

    }
}