package com.practice.Easy;

/**
 * Given an array containing n integers. The problem is to find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
 * Examples: 
 *
 * Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
 * Output : -6
 * Subarray is {-4, 2, -3, -1} = -6
 *
 * Input : arr = {2, 6, 8, 1, 4}
 * Output : 1
 */
public class MinSumOfAllSubArrays {

    int smallestSumSubarr(int arr[]) {
        int min_ending_here = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; ++i){
            if (min_ending_here > 0)
                min_ending_here = arr[i];
            else
                min_ending_here += arr[i];
            ans = Math.min(ans, min_ending_here);
        }
        return ans;
    }

}
