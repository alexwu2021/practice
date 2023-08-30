package com.practice.Medium;

import CommonTypes.TreeNode;

public class MaxPathSum {
    int maxVal;
    public int maxPathSum(TreeNode root){
        maxVal = Integer.MIN_VALUE;
        dfs(root);
        return maxVal;
    }

    private int dfs(TreeNode node){
        if(node==null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        maxVal = Math.max(maxVal, left + right + node.val);
        return Math.max(left , right) + node.val; // different from the above
    }
}
