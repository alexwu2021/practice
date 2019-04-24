package Easy;

import CommonTypes.TreeNode;

public class HouseRobber3 {

    /** now only one layer of the given tree can be robbed
     *
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber III.
     * Memory Usage: 38.6 MB, less than 61.09% of Java online submissions for House Robber III.
     *
     *
     * @param root
     * @return the max a robber can rob following the binary tree rules
     */
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int [] res = robDfs(root);
        return res[1];
    }

    /**
     * @param root
     * @return a pair of integer representing the gains from robbing two consective layers
     * int[0] --> no rob the current house
     * int[1] --> rob it
     *
     */
    public int[] robDfs(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int [] lefties = robDfs(root.left);
        int [] righties = robDfs(root.right);

        return new int[]{
                // the trailing one
                lefties[1] + righties[1],

                // the most advanced one
                Math.max(lefties[1] + righties[1], lefties[0] + righties[0] + root.val)};

    }
}
