package Easy;

import CommonTypes.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


/**
 * lines of slope -1 passing between nodes of binary tree,
 *
 * assigning each node into a set of N diagonal groups, where N is the max height of the left child tree
 *
 * the purpose is to traverse the tree and get a map storing the diagonal level to the sum of each node within that
 *
 * diagonal group
 *
 */
public class DiagSumOfBTree {

    protected void computeDiagSum(TreeNode currentNode, int currDiag, Map<Integer, Integer> diagSum) {
        if (currentNode == null) return;

        computeDiagSum(currentNode.left, currDiag + 1, diagSum);
        diagSum.put(currDiag, diagSum.getOrDefault(currDiag, 0) + currentNode.val);
        computeDiagSum(currentNode.right, currDiag, diagSum);
    }

    /**
     * get the sum
     *
     * @param root
     * @param diagSum
     */
    public void computeDiagSum(TreeNode root, Map<Integer, Integer> diagSum) {
        computeDiagSum(root, 0, diagSum);
    }

    protected void diagonalPrintUtil(TreeNode root,int d, Map<Integer, Vector<Integer>> integerVectorMap){

        // Base case
        if (root == null) return;

        // get the list at the particular d value
        Vector<Integer> k = integerVectorMap.get(d);

        // k is null then create a vector and store the data
        if (k == null) {
            k = new Vector<>();
            k.add(root.val);
        } else { // k is not null then update the list
            k.add(root.val);
        }

        // Store all nodes of same line together as a vector
        integerVectorMap.put(d,k);

        // Increase the vertical distance if left child
        diagonalPrintUtil(root.left, d + 1, integerVectorMap);

        // Vertical distance remains same for right child
        diagonalPrintUtil(root.right, d, integerVectorMap);
    }


    /**
     * traverse
     *
     * @param root
     */
    private void diagonalPrint(TreeNode root) {
        // create a map of vectors to store Diagonal elements
        Map<Integer,Vector<Integer>> integerVectorMap = new HashMap<>();
        diagonalPrintUtil(root, 0, integerVectorMap);

        //System.out.println("Diagonal Traversal of Binnary Tree");
        for (Map.Entry<Integer, Vector<Integer>> entry : integerVectorMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
