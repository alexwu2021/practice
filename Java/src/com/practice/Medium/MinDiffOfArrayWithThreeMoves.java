package com.practice.Medium;

import java.util.Arrays;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * Medium
 * 776

 * Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
 *
 * Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * Example 2:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 * Example 3:
 *
 * Input: nums = [6,6,0,1,1,4,6]
 * Output: 2
 * Example 4:
 *
 * Input: nums = [1,5,6,14,15]
 * Output: 1
 */
public class MinDiffOfArrayWithThreeMoves {

    public int minDifference(int[] A) {
        int n = A.length;
        int mx = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        mx =  Math.min(mx, A[n - 1] - A[3]); // off 3 smallest
        mx =  Math.min(mx, A[n - 2] - A[2]); // off 1 biggest, 2 smallest
        mx =  Math.min(mx, A[n - 3] - A[1]); // off 2 biggest, 1 smallest
        mx =  Math.min(mx, A[n - 4] - A[0]); // off 3 biggest
        return mx;
    }
}
