package com.practice.Medium;

import CommonTypes.TreeNode;

/**
 *
 */
public class DeleteANodeFromBst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val); // be watchful, the second should be root.val, not key
        }
        return root;
    }

    private TreeNode findMin(TreeNode p){
        while(p.left != null) p = p.left;
        return p;
    }
}
