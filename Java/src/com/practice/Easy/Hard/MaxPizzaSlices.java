package com.practice.Easy.Hard;

import java.util.Arrays;

/**
 * There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:
 *
 * You will pick any pizza slice.
 * Your friend Alice will pick next slice in anti clockwise direction of your pick.
 * Your friend Bob will pick next slice in clockwise direction of your pick.
 * Repeat until there are no more slices of pizzas.
 * Sizes of Pizza slices is represented by circular array slices in clockwise direction.
 *
 * Return the maximum possible sum of slice sizes which you can have.
 *
 *
 */
public class MaxPizzaSlices {

    public int maxSizeSlices(int[] slices) {
        int n = slices.length, numToPick = n / 3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, n-1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, n);
        return Math.max(maxSum(slices1, numToPick), maxSum(slices2, numToPick));
    }

    /**
     * max sum when pick `d` non-adjacent elements from `arr`
     * @param arr: the non-circular array resembling the original slice, but of length n-1
     * @param num: the number of non-adjacent elements to pick up
     * @return
     */
    int maxSum(int[] arr, int num) {
        int m = arr.length;

        // dp[i][j] stores the max sum when we pick `j` elements
        // from the non-circular array arr up to and including the `i` element
        int[][] dp = new int[m+1][num+1];

        for (int d = 1; d <= num; ++d) {
            for (int i = 1; i <= m; ++i) {
                if (i == 1) { // arr has only 1 element
                    dp[i][d] = arr[0]; // pick it up
                } else {
                    dp[i][d] = Math.max(
                            dp[i-1][d],         // pick up `d` elements without the `ith` element
                            dp[i-2][d-1]        // choose `d-1` elements from arr up to `i-2`
                                    + arr[i-1]  // plus the `ith` element
                    );
                }
            }
        }
        return dp[m][num];
    }
}
