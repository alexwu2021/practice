package Hard;

import CommonTypes.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
    }
}