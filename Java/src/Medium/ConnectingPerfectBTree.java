package Medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class ConnectingPerfectBTree {

    private Node _root;
    public Node connect_dfs(Node root) {
        if(root == null || root.left == null) return root;
        _root = root;
        link(root.left, root.right);
        return _root;
    }

    private void link(Node left, Node right){
        if(left==null && right==null) return ;
        left.next = right;

        link(left.left,left.right);
        link(left.right,right.left);
        link(right.left,right.right);
    }

    public Node connect_bfs(Node root) {
        if (root == null) {
            return root;
        }
        _root = root;
        for (Node head = root; head.left != null; head = head.left) {
            for (Node parent = head; parent != null; parent = parent.next) {
                parent.left.next = parent.right;
                if (parent.next != null) {
                    parent.right.next = parent.next.left;
                }
            }
        }
        return _root;
    }
    public Node connect_bfs2(Node root) {
        if(root == null) return root;
        _root = root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            Node front = null; // initializing prev to null
            for (int i = 0; i < n; ++i) {
                Node prev = front;
                front = q.poll();
                // i > 0 because when i is 0 prev points
                // the last node of previous level,
                // so we skip it
                if (i > 0)
                    prev.next = front;

                if (front.left != null)
                    q.add(front.left);
                if (front.right != null)
                    q.add(front.right);
            }
            // pointing last node of the nth level to null
            front.next = null;
        }
        return _root;
    }
}
