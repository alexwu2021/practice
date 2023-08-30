package com.practice.Medium;



import com.practice.DataStructure.CommonTypes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBTreeInSymentricWay {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<>();

        int totalRows = getHeight(root);
        int col = (int) Math.pow(2, totalRows) - 1;


        List<String> proto = new ArrayList<>();
        for(int i = 0; i < col; ++i)  proto.add("");
        for(int j = 0; j < totalRows; ++j)  ret.add(new ArrayList<>(proto));

        dfs(root, ret, 0, totalRows,  0, col - 1);

        return ret;
    }

    /** recursively set the middle of the current row to currNode's val
     *
     * @param currNode
     * @param result
     * @param curRow
     * @param totalRows
     * @param i
     * @param j
     */
    void dfs(TreeNode currNode, List<List<String>> result, int curRow, int totalRows, int i, int j) {
        if(currNode == null || curRow == totalRows)  return;

        result.get(curRow).set((i + j) >> 1, String.valueOf(currNode.val));

        dfs(currNode.left, result, curRow + 1, totalRows, i, ((i + j) >> 1) - 1);

        dfs(currNode.right, result, curRow + 1, totalRows, ((i + j) >> 1) + 1, j);
    }

    int getHeight(TreeNode root) {
        if(root == null)  return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
