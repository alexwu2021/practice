package com.practice.Easy;

public class HouseRobber {

    /** the only constraint is not to rob two house in a row
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;

        int rob = 0, norob = 0;
        for(int i = 0; i< nums.length; ++i){
            int robCurr = nums[i] + norob;
            norob = Math.max(norob, rob);
            rob = robCurr;
        }
        return Math.max(rob, norob);
    }
}
