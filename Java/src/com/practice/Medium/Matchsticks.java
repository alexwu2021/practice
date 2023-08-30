package com.practice.Medium;

import java.util.*;

public class Matchsticks {

    public boolean makesquare(int[] matches) {
        int sum = Arrays.stream(matches).sum();
        if (sum % 4 != 0) return false;
        // the convertion to boxed is necessary for sorting by reverse order
        Integer[] M = Arrays.stream(matches).boxed().toArray(Integer[]::new);

        // for speed gains
        // let the bigger one form a side first
        Arrays.sort(M, Collections.reverseOrder());

        return dfs(M, new int[4], 0, sum/4);
    }
    private boolean dfs(Integer[] nums, int[] sums, int index, int target) {
        if (index == nums.length) return true;
        for (int i = 0; i < 4; ++i) {
            if(sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        return false;
    }
}
