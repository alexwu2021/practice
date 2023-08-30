package com.practice.Easy;

import CommonUtils.TwoDimensionObjectCompare;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class MatrixCellsInDistanceOrderTest {

    @Test
    public void allCellsDistOrder() {
        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
        int R, C, r0, c0;
        int [][] actual;
        int[][] expected;

        /*
        Example 1:
         *
         * Input: R = 1, C = 2, r0 = 0, c0 = 0
         * Output: [[0,0],[0,1]]
         * Explanation: The distances from (r0, c0) to other cells are: [0,1]
         * Example 2:
         *
         * Input: R = 2, C = 2, r0 = 0, c0 = 1
         * Output: [[0,1],[0,0],[1,1],[1,0]]
         * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
         * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
         * Example 3:
         *
         * Input: R = 2, C = 3, r0 = 1, c0 = 2
         * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
         * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
         * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
         *
         */

        R = 1;
        C = 2;
        r0 = c0 = 0;
        actual = matrixCellsInDistanceOrder.allCellsDistOrder(R, C, r0, c0);
        assertNotNull(actual);

        expected = new int[2][2];
        expected[0] = new int []{0, 0};
        expected[1] = new int []{0, 1};

        assertTrue(TwoDimensionObjectCompare.equals(actual, expected));


        /* test case 1 */

        R = 2;
        C = 2;
        r0 = 0;
        c0 = 1;
        actual = matrixCellsInDistanceOrder.allCellsDistOrder(R, C, r0, c0);
        assertNotNull(actual);

//        expected = new int[4][2];
//
//        expected[0] = new int []{0, 0};
//        expected[1] = new int []{0, 1};
//        expected[2] = new int []{1, 1};
//        expected[3] = new int []{1, 0};
//
//
//        assertTrue(TwoDimensionObjectCompare.equals(actual, expected));


    }
}