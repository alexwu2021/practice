package Hard;

import CommonTypes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
