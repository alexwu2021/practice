package Medium;

import CommonTypes.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    private void loop(Deque<TreeNode> deq, boolean leftToRight, List<Integer>layer){
        List<TreeNode>temp = new ArrayList<>();
        Iterator<TreeNode>  iterator = deq.iterator();
        while(iterator.hasNext()){
            TreeNode tn = iterator.next();
            if(tn.left != null) temp.add(tn.left);
            if(tn.right != null) temp.add(tn.right);
            if(leftToRight) layer.add(tn.val);
            else layer.add(0, tn.val);
        }
        deq.clear();
        deq.addAll(temp);
    }

    /** passed oj
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deq = new LinkedList<>();
        deq.offer(root);
        int level = 0;
        while(!deq.isEmpty()){
            List<Integer>layer = new ArrayList<>();
            loop(deq, (level & 1) == 0, layer);
            level++;
            res.add(layer);
        }
        return res;
    }


    /* biedengle2's dfs

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    travel(res, 0, root);
    return res;
}
private void travel(List<List<Integer>> res, int level, TreeNode cur) {
    if (cur == null) return;
    if (res.size() <= level) {
        res.add(new ArrayList<Integer>());
    }
    if (level % 2 == 0) {
        res.get(level).add(cur.val);
    }   else {
        res.get(level).add(0, cur.val);
    }
    travel(res, level + 1, cur.left);
    travel(res, level + 1, cur.right);
}
     */
}
