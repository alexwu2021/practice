package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.TreeNode;
import org.junit.Test;

public class BstFromPreOrderTest {

    @Test
    public void bstFromPreorder() {

        BstFromPreOrder bstFromPreOrder = new BstFromPreOrder();
        int [] preorder;
        TreeNode actual, expeced;

        preorder = new int [] {8,5,1,7,10,12};

        expeced = new TreeNode(8);

        actual = bstFromPreOrder.bstFromPreorder(preorder);

    }
}