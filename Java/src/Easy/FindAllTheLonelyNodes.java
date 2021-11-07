package Easy;

import CommonTypes.TreeNode;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindAllTheLonelyNodes {

    public List<Integer> dfs(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        dfs(root, false, vals); // by definition, root is not a lonely node
        return vals;
    }

    private void dfs(TreeNode n, boolean isNLonely, List<Integer> vals) {
        if (n == null) return;

        if (isNLonely) {
            vals.add(n.val);
            //no, we should not return here!!
        }
        dfs(n.left, n.right == null, vals);
        dfs(n.right, n.left == null, vals);
    }

    public List<Integer> getLonelyNodes_i(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                if (node.right == null)
                    ans.add(node.left.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                if (node.left == null)
                    ans.add(node.right.val);
            }
        }
        return ans;
    }


//    the wrong way
//    public List<Integer> getLonelyNodes(TreeNode root) {
//        List<Integer>ans = new ArrayList<>();
//
//        boolean f = (root.left != null && root.right != null);
//        dfs(root.left, ans, f);
//        dfs(root.right, ans, f);
//        return ans;
//    }
//
//    private void dfs(TreeNode n, List<Integer>lst, boolean hasCouson){
//        if(n == null) return;
//        if(n.left == null && n.right == null && !hasCouson){
//            lst.add(n.val);
//            //return;
//        }
//
//        dfs(n.left, lst, (n.left != null && n.right != null));
//        dfs(n.right, lst, (n.left != null && n.right != null));
//    }

}
