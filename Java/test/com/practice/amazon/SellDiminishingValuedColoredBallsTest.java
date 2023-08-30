package com.practice.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellDiminishingValuedColoredBallsTest {

    @Test
    public void maxProfit() {
        SellDiminishingValuedColoredBalls sol = new SellDiminishingValuedColoredBalls();

        int[] inv;
        int orders;
        int actual, expected;


//        Input: inventory = [2,5], orders = 4
//        Output: 14
//        Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 3).
//                The maximum total value is 2 + 5 + 4 + 3 = 14.
        inv = new int[]{2, 5};
        orders = 4;
        expected = 14;
        actual = sol.maxProfit(inv, orders);
        Assert.assertEquals(expected, actual);


//        Input: inventory = [3,5], orders = 6
//        Output: 19
//        Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2).
//                The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
        inv = new int[]{3, 5};
        orders = 6;
        expected = 19;
        actual = sol.maxProfit(inv, orders);
        Assert.assertEquals(expected, actual);


//        Input: inventory = [2,8,4,10,6], orders = 20
//        Output: 110
//        inv = new int[]{2,8,4,10,6};
//        orders = 20;
//        expected = 110;
//        actual = sol.maxProfit(inv, orders);
//        Assert.assertEquals(expected, actual);

//
//        Input: inventory = [1000000000], orders = 1000000000
//        Output: 21
//        Explanation: Sell the 1st color 1000000000 times for a total value of 500000000500000000.
//        500000000500000000 modulo 109 + 7 = 21.
        inv = new int[]{1000000000};
        orders = 1000000000;
        expected = 21;
        actual = sol.maxProfit(inv, orders);
        Assert.assertEquals(expected, actual);

    }
}