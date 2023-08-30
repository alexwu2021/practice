package com.practice.Easy;

public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    int dfs(int[] nums, int i, int curr){
        if(i == nums.length) return curr;
        return dfs(nums, i+1, curr) + dfs(nums, i+1, curr^nums[i]);
    }
}
