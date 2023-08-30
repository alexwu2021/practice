package com.practice.Easy;

import CommonTypes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class UnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        //this passed, but always feel we should do a checking here
        return dfs(root, root.val);
    }

    boolean dfs(TreeNode node, int expected){
        if(node == null) return true;
        if(node.val != expected) return false;
        return dfs(node.left, expected) && dfs(node.right, expected);
    }

    public boolean isUnivalTree2(TreeNode root) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int expected = root.val;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null) continue;

            if(curr.val != expected)
                return false;

            q.offer(curr.left);
            q.offer(curr.right);
        }
        return true;

    }
}

