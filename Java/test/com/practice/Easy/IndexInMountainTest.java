package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndexInMountainTest {

    @Test
    public void peakIndexInMountainArray() {

        IndexInMountain sol = new IndexInMountain();
        int[] arr;
        int actual, expected;

        //        Input: arr = [0,1,0]
        //        Output: 1
        arr = new int[]{0,1,0};
        expected = 1;
        actual = sol.peakIndexInMountainArray(arr);
        Assert.assertEquals(expected, actual);

        //        Input: arr = [0,2,1,0]
        //        Output: 1
        arr = new int[]{0,2,1,0};
        expected = 1;
        actual = sol.peakIndexInMountainArray(arr);
        Assert.assertEquals(expected, actual);

        //        Input: arr = [0,10,5,2]
        //        Output: 1
        arr = new int[]{0,10,5,2};
        expected = 1;
        actual = sol.peakIndexInMountainArray(arr);
        Assert.assertEquals(expected, actual);

        //        Input: arr = [3,4,5,1]
        //        Output: 2
        arr = new int[]{3,4,5,1};
        expected = 2;
        actual = sol.peakIndexInMountainArray(arr);
        Assert.assertEquals(expected, actual);


        //        Input: arr = [24,69,100,99,79,78,67,36,26,19]
        //        Output: 2
        arr = new int[]{24,69,100,99,79,78,67,36,26,19};
        expected = 2;
        actual = sol.peakIndexInMountainArray(arr);
        Assert.assertEquals(expected, actual);
    }
}