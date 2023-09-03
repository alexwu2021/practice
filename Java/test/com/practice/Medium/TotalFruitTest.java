package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalFruitTest {


    @Test
    void testTotalFruit() {

        TotalFruit totalFruit = new TotalFruit();
        int actual, expected;
        int[] inputs = {1, 2, 1};

//        expected = 3;
//        actual = totalFruit.totalFruit(inputs);
//        assertTrue(expected == actual);

        inputs = new int []{0, 1, 2, 2};
        expected = 3;
        actual = totalFruit.totalFruit(inputs);
        assertTrue(expected == actual);

//        Input: fruits = [0,1,2,2]
//        Output: 3
//        Explanation: We can pick from trees [1,2,2].
//        If we had started at the first tree, we would only pick from trees [0,1].
//        Example 3:

        inputs = new int []{1, 1, 3, 2, 2};
        expected = 4;
        actual = totalFruit.totalFruit(inputs);
        assertTrue(expected == actual);

//        Input: fruits = [1,2,3,2,2]
//        Output: 4
//        Explanation: We can pick from trees [2,3,2,2].
//        If we had started at the first tree, we would only pick from trees [1,2].

    }
}