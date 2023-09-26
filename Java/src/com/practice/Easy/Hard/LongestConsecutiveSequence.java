package com.practice.Easy.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int n : nums) mp.put(n, 1);
        int ret = Integer.MIN_VALUE;
        for(int n : nums){
            if(mp.get(n) == 0) continue;

            int count = 1;
            int temp = n + 1;
            while(mp.getOrDefault(temp, 0) != 0){
                count++;
                mp.put(temp++, 0);
            }
            temp = n - 1;
            while(mp.getOrDefault(temp, 0) != 0){
                count++;
                mp.put(temp--, 0);
            }

            ret = Math.max(ret, count);
        }
        return ret;
    }
}
