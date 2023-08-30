package com.practice.Hard;

import CommonTypes.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SerializeAndDeserializeBinaryTreeTest {

    @Test
    public void serialize() {
        SerializeAndDeserializeBinaryTree sol = new SerializeAndDeserializeBinaryTree();
        String expected, actual;
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        expected = "[5,3,7,null,null,6,null,null,null]";
        actual = sol.serialize(root);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void deserialize() {
        SerializeAndDeserializeBinaryTree sol = new SerializeAndDeserializeBinaryTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        String repr = sol.serialize((root));
        TreeNode res = sol.deserialize(repr);
        Assert.assertEquals("root not the same", res.val, root.val);

        String new_repr = sol.serialize(res);
        Assert.assertEquals("representation is not the same", new_repr, repr);


        root.right.right = new TreeNode(1001);
        root.right.right.left = new TreeNode(99);
        root.right.right.left.left = new TreeNode(88);
        repr = sol.serialize((root));
        res = sol.deserialize(repr);
        new_repr = sol.serialize(res);
        Assert.assertEquals("representation is not the same", new_repr, repr);
    }
}