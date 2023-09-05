package com.practice.Easy;

import com.practice.DataStructure.CommonTypes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BstMinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int minDepth = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            depth++;

            List<TreeNode> list = new ArrayList<>();
            while(size > 0){
                TreeNode front = q.poll();
                if(front.left == null && front.right == null){
                    minDepth = Math.min(minDepth, depth);
                }

                if(front.left != null){
                    list.add(front.left);
                }
                if(front.right != null){
                    list.add(front.right);
                }
                size--;
            }
            for(TreeNode tn: list){
                q.offer(tn);
            }
        }
        return minDepth;
    }

    public int minDepth_dfs(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        if(root.left == null){
            return 1 + dfs(root.right);
        }

        if(root.right == null){
            return 1 + dfs(root.left);
        }

        return 1 + Math.min(dfs(root.left), dfs(root.right));

    }


}
