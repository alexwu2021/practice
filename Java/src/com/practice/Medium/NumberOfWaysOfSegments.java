package com.practice.Medium;

/**
 *  1621
 *  
 * Given n points on a 1-D plane, where the ith point (from 0 to n-1) is at x = i, find the number of ways we can draw exactly k non-overlapping line segments such that each segment covers two or more points. The endpoints of each segment must have integral coordinates. The k line segments do not have to cover all n points, and they are allowed to share endpoints.
 *
 * Return the number of ways we can draw k non-overlapping line segments. Since this number can be huge, return it modulo 109 + 7.
 */

// For every pair (i,j) , number of ways are number of ways with (i-1, j) + number of ways with (for every 0 to i-1, j-1).
public class NumberOfWaysOfSegments {

    public int numberOfSets(int n, int k) {
        long mod = 1000_000_007;
        if(k == 1){
            return n*(n-1)/2;
        }
        long [][]dp = new long[n][k];
        for(int i=1;i<n;++i){
            dp[i][0] = dp[i-1][0] + i*(i+1)/2;
        }
        // For every pair (i,j) , number of ways are number of ways with (i-1, j)
        // + number of ways with (for every 0 to i-1, j-1).

        for(int i=2;i<n;i++){
            for(int j=1;j<i && j<k;++j){
                dp[i][j] = dp[i-1][j] - dp[i-2][j] + dp[i-1][j-1] + mod;
                dp[i][j] %= mod;
                dp[i][j] += dp[i-1][j];
            }
        }

        return (int)(dp[n-1][k-1] - dp[n-2][k-1]);
    }
}
