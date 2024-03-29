package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.TreeNode;

/**
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 *
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 *
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 *
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 *
 *
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 *
 * Note:
 *
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 */
public class BinaryTreePruning {

    /** passed oj, inspired by lee215 and agritsik
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.right == null && root.left == null && root.val == 0) ? null : root;
    }

    /** This is a bad idea, never do this!
     * @param root
     * @param parent
     * @param isLeftChild
     */
    void dfs(TreeNode root, TreeNode parent, boolean isLeftChild){
        if(root.left == null && root.right == null){
            if(root.val != 1){
                if(isLeftChild) parent.left = null;
                else parent.right = null;
            }
            return ;
        }
        if(root.left != null) dfs(root.left, root, true);
        if(root.right != null) dfs(root.right, root, false);
    }

}
