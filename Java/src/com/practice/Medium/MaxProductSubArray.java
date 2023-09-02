package com.practice.Medium;

public class MaxProductSubArray {

    /** shadow min solution
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0){  // <-- when negative element appears, swap min into max and v.v. for max
                int temp = max;
                max = min;
                min = temp;
            }
//            max = Math.max(max, max * nums[i]); // <-- this won't work
            max = Math.max(nums[i], max * nums[i]);

            min = Math.min(nums[i], min * nums[i]);

            ans = Math.max(ans, max);
        }
        return ans;
    }
}
