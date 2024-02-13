package com.practice.Medium;

import com.practice.DataStructure.CommonTypes.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode res = dfs(root, p, q);
        if (res == p) return dfs(p, q, q) != null ? res : null;
        if (res == q) return dfs(q, p, p) != null ? res : null;
        return res;
    }

    // in the subtree of root, find the lca of p and q
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = dfs(root.left, p, q), right = dfs(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
