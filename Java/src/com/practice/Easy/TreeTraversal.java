package com.practice.Easy;

import CommonTypes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    private void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        if(root.left != null){
            inorderTraversalHelper(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            inorderTraversalHelper(root.right, list);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }
}
