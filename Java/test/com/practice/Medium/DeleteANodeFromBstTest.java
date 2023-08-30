package com.practice.Medium;


import com.practice.DataStructure.CommonTypes.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DeleteANodeFromBstTest {

    @Test
    public void deleteNode() {
        DeleteANodeFromBst sol = new DeleteANodeFromBst();
        TreeNode root = null, actual, expected;
        int key;

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        expected = new TreeNode(5);
        expected.left = new TreeNode(4);
        expected.right = new TreeNode(6);
        expected.left.left = new TreeNode(2);
        expected.right.right = new TreeNode(7);

        key = 3;
        actual = sol.deleteNode(root, key);
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringOverriddenEqualsForTypes(TreeNode.class, TreeNode.class)
                .isEqualTo(expected);

    }
}