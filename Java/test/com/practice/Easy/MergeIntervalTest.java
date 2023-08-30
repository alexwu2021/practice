package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalTest {

    /**
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     *
     */
    @Test
    public void mergeTest1() {
        MergeInterval sol = new MergeInterval();
        int[][] intervals, actual, expected;

        intervals = new int[4][2];
        int i = 0;
        intervals[i++] = new int []{1, 3};
        intervals[i++] = new int []{2, 6};
        intervals[i++] = new int []{8, 10};
        intervals[i++] = new int []{15, 18};

        actual = sol.merge_no_sort(intervals);
        expected = new int[3][2];
        int j = 0;
        expected[j++] = new int[]{1, 6};
        expected[j++] = new int[]{8, 10};
        expected[j++] = new int[]{15, 18};
        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     */
    @Test
    public void mergeTest2() {
        MergeInterval sol = new MergeInterval();
        int[][] intervals, actual, expected;

        intervals = new int[2][2];
        int i = 0;
        intervals[i++] = new int []{1, 4};
        intervals[i++] = new int []{4, 5};

        actual = sol.merge_no_sort(intervals);
        expected = new int[1][2];
        int j = 0;
        expected[j++] = new int[]{1, 5};
        Assert.assertArrayEquals(expected, actual);
    }
}