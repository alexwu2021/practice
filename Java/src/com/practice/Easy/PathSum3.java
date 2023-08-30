package com.practice.Easy;

import CommonTypes.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    /** passed oj, borrowed from tankztc
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap(); //target value and how many ways to arrive at the targetted value
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) return 0; // this is the part that easily gets lost

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res     +=  helper(root.left, currSum, target, preSum)
                +   helper(root.right, currSum, target, preSum);

        // tail spin
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }
}
