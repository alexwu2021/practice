package com.practice.Easy;

public class SubarrayWithConstraints {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for(int i = 0; i< nums.length;){
            int l, r;
            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                l = i;
                r = l + 1;
                while(r < nums.length && nums[r] <= threshold && nums[r-1] % 2 != nums[r] % 2){
                    r++;
                }
                ans = Math.max(ans, r - l);
                i = r;
            } else {
                i++;
            }
        }
        return ans;
    }
}
