package com.practice.Easy;

import java.util.List;

public class MaxNMaryTreeDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Solution {
        int maxDepth;


        /** passed oj by me
         * @param root
         * @return
         */
        public int maxDepth(Node root) {
            if(root == null)
                return 0;
            maxDepth = Integer.MIN_VALUE;
            dfs(root, 1);
            return maxDepth;
        }

        void dfs(Node root, int level) {
            if(root == null)  return;

            if(level > maxDepth)
                maxDepth = level;


            for(Node nd : root.children){
                dfs(nd,level + 1);
            }
        }
    }
}
