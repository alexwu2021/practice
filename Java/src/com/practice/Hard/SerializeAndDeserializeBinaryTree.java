package com.practice.Hard;

import CommonTypes.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        Queue<TreeNode>q = new LinkedList<>();
        List<List<TreeNode>>layers = new LinkedList<>();
        q.offer(root);
        List<TreeNode>top = new ArrayList<>();
        top.add(root);
        layers.add(top);

        while(!q.isEmpty()){
            List<TreeNode> layer = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode t = q.poll();
                if(t.val == Integer.MIN_VALUE) continue;
                if(t.left != null){
                    layer.add(t.left);
                }else{
                    layer.add(new TreeNode(Integer.MIN_VALUE));
                }
                if(t.right != null){
                    layer.add(t.right);
                }else{
                    layer.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
            if(layer.size() > 0)
                layers.add(layer);

            for(TreeNode tn: layer)
                q.offer(tn);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(List<TreeNode> lst : layers){
            for(TreeNode t: lst){
                String repr = t.val == Integer.MIN_VALUE ? "null" : "" + t.val;
                sb.append(repr + ",");
            }
        }
        String ret = sb.toString();
        ret = ret.substring(0, ret.length() -1);
        return ret + "]";
    }

    private TreeNode createTreeNode(String val){
        if(val.equals("null"))
            return null;
        return new TreeNode(Integer.valueOf(val));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);
        if(data.length() <= 0)
            return null;
        TreeNode root = null;
        if(data.indexOf(",") < 0)
            return createTreeNode(data);

        String[] sa = data.split(",");
        root = createTreeNode(sa[0]);
        Queue<TreeNode>q = new ArrayDeque<>();
        q.offer(root);
        int i = 0;
        while(!q.isEmpty()){
         TreeNode temp = q.poll();
         temp.left = createTreeNode(sa[i+1]);  // heap style
         if(temp.left!= null)
            q.offer(temp.left);

         temp.right = createTreeNode(sa[i+2]); // heap style
         if(temp.right!= null)
            q.offer(temp.right);

         i += 2;
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
