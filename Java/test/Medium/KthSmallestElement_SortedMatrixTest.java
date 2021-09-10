package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestElement_SortedMatrixTest {

    @Test
    public void kthSmallest() {
        KthSmallestElement_SortedMatrix sol = new KthSmallestElement_SortedMatrix();
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 5, 9};
        matrix[1] = new int[]{10,11, 13};
        matrix[2] = new int[]{12, 13, 15};
        int k = 8;
        int actual = sol.kthSmallest(matrix, k);
        int expected = 13;
        Assert.assertTrue(expected == actual);

        k = 5;
        expected = 11;
        actual = sol.kthSmallest(matrix, k);
        Assert.assertTrue(expected == actual);
    }
}