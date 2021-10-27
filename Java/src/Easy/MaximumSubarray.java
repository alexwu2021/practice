package Easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int mx = nums[0];
        int ans = mx; // cherry picking
        for(int i = 1; i < nums.length; ++i){
            if(mx > 0) {
                mx += nums[i];
                continue;
            }
            if(nums[i] > 0) mx = nums[i];
            else mx = Math.max(mx, nums[i]);
            ans = Math.max(ans, mx);
        }
        return ans;
    }
}
