package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.TreeNode;
import org.junit.Test;

public class ValidBSTTest {

    @Test
    public void isValidBST() {
        ValidBST validBST = new ValidBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean res, expected;
        expected = false;
        res = validBST.isValidBST(root);
        assert (res == expected);
    }
}