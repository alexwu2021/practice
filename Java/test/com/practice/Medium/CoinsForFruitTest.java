package com.practice.Medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsForFruitTest {

    @Test
    void minimumCoins() {
        CoinsForFruit sol = new CoinsForFruit();
        int[] nums;
        int actual, expected;
        nums = new int[]{3, 1, 2};

        actual = sol.minimumCoins(nums);
        expected = 4;
        assertEquals(expected, actual);


        nums = new int[]{1,10,1,1};
        actual = sol.minimumCoins(nums);
        expected = 2;
        assertEquals(expected, actual);


        nums = new int[]{3,1,2, 7, 4, 5};
        actual = sol.minimumCoins(nums);
        expected = 5;
        assertEquals(expected, actual);


//        nums = new int[]{26,18,6,12,49,7,45,45};
//        actual = sol.minimumCoins(nums);
//        expected = 39;
//        assertEquals(expected, actual);

    }
}