package com.practice.Easy;

import java.util.Arrays;

public class ProductExceptSelf {

    /** passed oj
     *
     *  Runtime: 2 ms, faster than 18.16% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 43.8 MB, less than 21.85% of Java online submissions for Product of Array Except Self.
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res, 1);

        int left = 1, right = 1;
        for(int i = 0; i < n; ++i){
            res[i] *= left;
            left *= nums[i];
        }

        for(int i = n - 1; i >= 0; --i){
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
