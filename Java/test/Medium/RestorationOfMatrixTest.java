package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestorationOfMatrixTest {

    @Test
    public void restoreMatrix() {

        int[] rowSum, colSum;
        int[][] actual, expected;
        RestorationOfMatrix sol = new RestorationOfMatrix();


        //        Example 1:
//
//        Input: rowSum = [3,8], colSum = [4,7]
//        Output: [[3,0],
//         [1,7]]
//        Explanation:
//        0th row: 3 + 0 = 3 == rowSum[0]
//        1st row: 1 + 7 = 8 == rowSum[1]
//        0th column: 3 + 1 = 4 == colSum[0]
//        1st column: 0 + 7 = 7 == colSum[1]
//        The row and column sums match, and all matrix elements are non-negative.
//                Another possible matrix is: [[1,2],
//                             [3,5]]
        rowSum = new int[]{3, 8};
        colSum = new int[] {4, 7};
        expected = new int[2][];
        int i = 0;
        expected[i++] = new int [] {3,0};
        expected[i++] = new int [] {1,7};
        actual = sol.restoreMatrix(rowSum, colSum);
        Assert.assertArrayEquals(expected, actual);


//        Example 2:
//
//        Input: rowSum = [5,7,10], colSum = [8,6,8]
//        Output: [[0,5,0],
//         [6,1,0],
//         [2,0,8]]
//        Example 3:
//
//        Input: rowSum = [14,9], colSum = [6,9,8]
//        Output: [[0,9,5],
//         [6,0,3]]
//        Example 4:
//
//        Input: rowSum = [1,0], colSum = [1]
//        Output: [[1],
//         [0]]
//        Example 5:
//
//        Input: rowSum = [0], colSum = [0]
//        Output: [[0]]
    }
}