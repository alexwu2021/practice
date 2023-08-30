package com.practice.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class CountTheRemainder {
    /** Calculate the prefix sum and count it.
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> counter = new HashMap<>();

        // add the default case
        counter.put(0, 1); // pay attention to this, without this, the value will be off

        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + a % K + K) % K; // add K to avoid negative

            // only qualifies the prefix for subarrays that have a sum divisible by K
            res += counter.getOrDefault(prefix, 0);

            // update the prefix's value in counter
            counter.put(prefix, counter.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
