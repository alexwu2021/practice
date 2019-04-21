package Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixSearch2Test {

    @Test
    public void searchMatrix() {
        MatrixSearch2 matrixSearch2 = new MatrixSearch2();
        int [][] matrix= {{5,6,10,14},{6,10,13,18}, {10,13,18,19}};
        int target = 14;
        boolean expected, actual;
        expected = true;
        actual = matrixSearch2.searchMatrix(matrix, target);
        assert (expected == actual);

    }
}