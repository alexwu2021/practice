package com.practice.Medium;

import CommonTypes.TreeNode;

/**
 * # 1008
 */
public class BstFromPreOrder {

    /**
     * Runtime: 1 ms, faster than 82.38% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
     * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
     * Next challenges:
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) return null;
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        if(start > end) return null;
        if(end == start) return new TreeNode(preorder[start]);

        int val = preorder[0];
        TreeNode ans = new TreeNode(val);

        // locate the partition point p
        int p = start + 1;
        while(p <= end && preorder[p] < val ) { p++; }

        ans.left = dfs(preorder, start + 1, p - 1);
        ans.right = dfs(preorder, p, end);
        return ans;
    }

}
