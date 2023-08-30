package com.practice.Special.DP;

import org.junit.Test;

public class BuySellStock1Test {

    @Test
    public void maxProfit1() {
        BuySellStock1 buySellStock1 = new BuySellStock1();
        int [] prices;
        int res, expected;

        prices = new int [] {3, 3};
        res = buySellStock1.maxProfit1(prices);
        expected = 0;
        assert(res == expected);


        prices = new int [] {7,1,5,3,6,4};
        expected = 5;
        res = buySellStock1.maxProfit1(prices);
        assert(res == expected);


        prices = new int [] {1, 2, 3, 4, 5};
        expected = 4;
        res = buySellStock1.maxProfit1(prices);
        assert(res == expected);

        prices = new int [] {2, 4, 1};
        expected = 2;
        res = buySellStock1.maxProfit1(prices);
        assert(res == expected);
    }
}