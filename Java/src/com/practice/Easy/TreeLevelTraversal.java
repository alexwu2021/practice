package com.practice.Easy;

import com.practice.DataStructure.CommonTypes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();

        if(root == null) return ans; // TODO: this is a must

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>list = new ArrayList<>();
            List<TreeNode>tempChildren = new ArrayList<>();
            while(size > 0){
                TreeNode front = q.poll();
                size--;

                list.add(front.val);

                if(front.left != null){
                    tempChildren.add(front.left);
                }
                if(front.right != null){
                    tempChildren.add(front.right);
                }
            }
            ans.add(list);
            for(TreeNode child: tempChildren){
                q.offer(child);
            }
        }
        return ans;
    }
}
