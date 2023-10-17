package com.practice.Hard;

import java.util.Arrays;
import java.util.List;

/**
 * 1326. Minimum Number of Taps to Open to Water a Garden
 *
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
 * (i.e., the length of the garden is n).
 *
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means
 * the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 *
 *
 */
public class MinTaps {

    /**
     * @param n total number of sections/areas of garden seperated by points
     * @param rng the range a ith tap can water
     * @return
     */
    public int minTaps(int n, int[] rng) {
        // dp[i] is the min number of tapes to water area from 0 to i
        int[] dp= new int[n + 1];

        Arrays.fill(dp, n+2);
        dp[0] = 0;

        for(int i = 0; i <= n; ++i) {
            int left = Math.max(0, i - rng[i]);     // find the leftmost point of garden(area) to water with tape i.
            int right = Math.min(n, i + rng[i]);    // find the rightmost point of garden(area) to water with tape i.
            for(int j=left+1; j<=right; ++j) {
                //Check if this range (left..right) can be watered using a smaller number of tapes than the previous
                dp[j] = Math.min(dp[j], dp[left] + 1); // dp[lef] + the smallest increase, which is 1, contributed by tap on i
            }
        }

        // If minimum tapes needed to water area 0..n is greater than n , it means we could not found minimum number of tapes
        return dp[n]  < n + 2 ? dp[n] : -1;
    }

}
