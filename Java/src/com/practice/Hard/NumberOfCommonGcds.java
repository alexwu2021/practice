package com.practice.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an array nums that consists of positive integers.
 *
 * The GCD of a sequence of numbers is defined as the greatest integer that divides all the numbers in the sequence evenly.
 *
 * For example, the GCD of the sequence [4,6,16] is 2.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * Return the number of different GCDs among all non-empty subsequences of nums.
 */
public class NumberOfCommonGcds {

    private Map<Integer, HashSet<Integer>> mp = new HashMap<>();
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int n = nums.length;
        Set<Integer>[][]dp = new Set[n][];
        for(int i=0; i<n; ++i)
            dp[i] = new HashSet[n];
        for(int i=0; i<n; ++i){
            dp[i][0] = getGcd(nums[i]);
        }
        for(int j=0; j<n; ++j){
            dp[0][j] = getGcd(nums[j]);
        }
        for(int l = 1; l<=n; ++l){
            for(int i=1; i<n; ++i) {
                for(int j = i+1; j< i+l-1; ++j){
                    dp[i][j] = new HashSet<>(dp[i-1][j]);
                    dp[i][j].addAll(getGcd(nums[i]));
                    dp[i][j].addAll(dp[i][j-1]);
                    dp[i][j].addAll(getGcd(nums[j]));
                }
            }
        }

        return dp[n-1][n-1].size();
    }


    private HashSet<Integer> getGcd(int num) {
        if(mp.containsKey(num))
            return mp.get(num);

        HashSet<Integer>ret = new HashSet<>();

        ret.add(1);
        for(int n=2; n<=num; ++n){
            if(num % n == 0)
                ret.add(n);
        }
        mp.put(num, ret);
        return ret;
    }
}
