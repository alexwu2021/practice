package Easy;

import CommonTypes.TreeNode;

public class EqualLeafTree {

    /** passed OJ
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        getLeaves(root1, l1);
        getLeaves(root2, l2);
        return l1.toString().equals(l2.toString());
    }

    void getLeaves(TreeNode temp, StringBuilder sb){
        if(temp == null)
            return;

        if(temp.left ==null && temp.right == null){
            sb.append(temp.val).append("-");
        }
        getLeaves(temp.left, sb);
        getLeaves(temp.right, sb);

    }
}
