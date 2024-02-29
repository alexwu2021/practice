package com.practice.Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStockWithKTest {

    @Test
    void maxProfit() {

        BuySellStockWithK sol = new BuySellStockWithK();
        int actual, expected;
        int[] prices = {3,3,5,0,0,3,1,4};
        actual = sol.maxProfit(prices);
        expected = 6;
        assert(expected == actual);

        prices = new int[]{1,2,3,4,5};
        actual = sol.maxProfit(prices);
        expected = 4;
        assert(expected == actual);

        prices = new int[]{7,6,4,3,1};
        actual = sol.maxProfit(prices);
        expected = 0;
        assert(expected == actual);


    }
}