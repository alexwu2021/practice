package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.TreeNode;

public class ValidBST {

    /** passed oj
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * @param root
     * @param minVal  has to be long
     * @param maxVal has to be long
     * @return
     */
    public boolean dfs(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;
        if(root.val >= maxVal) return false;
        if(root.val <= minVal) return false;
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
    }
}
