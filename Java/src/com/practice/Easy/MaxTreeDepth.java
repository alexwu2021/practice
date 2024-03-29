package com.practice.Easy;


import com.practice.DataStructure.CommonTypes.TreeNode;

public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
