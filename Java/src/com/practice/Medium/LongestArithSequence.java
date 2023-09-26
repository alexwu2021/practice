package com.practice.Medium;

import java.util.HashMap;

/**
 * 1027. Longest Arithmetic Subsequence
 * Medium
 * 4.4K
 * 197
 * company
 * Microsoft
 * company
 * Adobe
 * company
 * Amazon
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 */
public class LongestArithSequence {


     public int longestArithSeqLength(int[] nums) {
         int res = 2, n = nums.length;

         HashMap<Integer, Integer>[] dp = new HashMap[n];
         for(int i =0; i< nums.length; ++i){
             dp[i] = new HashMap<>();

             // iteratively adjust dp[i] using dup[j]
             for(int j = 0; j <i; ++j){
                 int diff = nums[i] - nums[j];

                 dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);

                 res = Math.max(res, dp[i].get(diff));
             }
         }
         return res;
     }
}
