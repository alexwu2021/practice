package Medium;

import CommonTypes.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 * oj passed. inspired by siyang2
 */
public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftSlideToPopulateStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


    /** this part has an amortized cost of 1
     * @return the next smallest number throughout the tree
     */
    public int next() {

        int val = stack.peek().val;
        TreeNode cur = stack.pop();

        // if curr has no null right sub tree, then shift to it
        if(cur.right != null){
            cur = cur.right;
            leftSlideToPopulateStack(cur);
        }
        return val;
    }

    /**
     * @param cur
     * hop down from cur's left slope and populate the stack
     * of length O(h)
     */
    private void leftSlideToPopulateStack(TreeNode cur){
        while(cur != null){
            stack.push(cur);
            if(cur.left != null) cur = cur.left;
            else break;
        }
    }
}
