package Medium;

import CommonTypes.TreeNode;

public class IncreaseOrderSearchTree {

    private TreeNode dfs(TreeNode root, TreeNode tail){
        if(root == null) return tail;
        //in the following, each line except the last one should touch root

        // this follows in order traversal:  root, root.left, root.right
        // root.left : root = root.right : tail


        TreeNode res = dfs(root.left, root);
        root.left = null;
        root.right = dfs(root.right, tail);
        return res;
    }

    public TreeNode increasingBST(TreeNode root) {
        return dfs(root, null);
    }
}
