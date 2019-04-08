package Easy;

import CommonTypes.NMaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversalOfNMaryTree {

    private void dfs(NMaryTreeNode root, List<Integer>ret) {
        if(root == null) return;
        ret.add(root.val);

        if(root.children == null || root.children.size() <= 0)
            return;

        for(NMaryTreeNode NMaryTreeNode: root.children){
            dfs(NMaryTreeNode, ret);
        }
    }


    /** passed oj
     * @param root
     * @return
     */
    public List<Integer> preorder(NMaryTreeNode root) {
        List<Integer>ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }


    public List<Integer> preorder_Iterative(NMaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<NMaryTreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) //this is the key point, we must add from the rhs
                stack.add(root.children.get(i));
        }

        return list;
    }
}
