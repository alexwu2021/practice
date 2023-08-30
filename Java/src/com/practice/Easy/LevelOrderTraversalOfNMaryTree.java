package com.practice.Easy;

import CommonTypes.NMaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalOfNMaryTree {

    /** passed oj
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NMaryTreeNode root) {
        List<List<Integer>>ret = new ArrayList<>();
        Queue<NMaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer>layer = new ArrayList<>();
            Queue<NMaryTreeNode>temp = new LinkedList<>();

            while(!queue.isEmpty()){
                NMaryTreeNode front = queue.poll();
                layer.add(front.val);

                for(NMaryTreeNode nd: front.children){
                    temp.offer(nd);
                }
            }

            ret.add(layer);
            queue.addAll(temp);
        }

        return ret;

    }
}
