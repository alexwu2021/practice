package com.practice.Medium;


import java.util.*;


class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n - 1];

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if(temp > target ){
                    end--;
                }else{
                    start++;
                }
                if(Math.abs(temp - target) < Math.abs(result-target))
                    result = temp;
            }
        }
        return result;
    }
}