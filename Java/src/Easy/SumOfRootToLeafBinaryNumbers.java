package Easy;

import CommonTypes.TreeNode;

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 *  Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class SumOfRootToLeafBinaryNumbers {

    private int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int val) {
        if(node == null){
            return;
        }

        val = val << 1 | node.val;
        if(node.left == null && node.right == null) {
            ans += val;
            return;
        }

        dfs(node.left, val);
        dfs(node.right, val);
    }
}
