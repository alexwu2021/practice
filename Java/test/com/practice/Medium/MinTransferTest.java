package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinTransferTest {

    MinTransfer sol = new MinTransfer();
    @Test
    void minTransfers_test1() {
        int[][]input = new int[][]{
            {0,1,10},
            {1,0,1},
            {1,2,5},
            {2,0,5}
        };
        int expected = 1, actual = sol.minTransfers(input);
        assertEquals(expected, actual);
    }

    @Test
    void minTransfers() {
        int[][]input = new int[][]{
                new int[]{0,1,10},
                new int[]{1,0,1},
                new int[]{1,2,5},
                new int[]{2,0,5}



//                  [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
        };
        int expected = 1, actual = sol.minTransfers(input);
        assertEquals(expected, actual);
    }
}