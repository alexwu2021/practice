package com.practice.Easy;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; ++i){  // i could be the last
            for(int j=i; j<nums.length; ++j) { // j could be the last
                int sum = 0;
                for (int k = i; k <= j; ++k) {
                    sum += nums[k];
                }

                if (sum >= target) {
                    ans = Math.min(ans, j-i+1);
                    break; // needed for speed
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
