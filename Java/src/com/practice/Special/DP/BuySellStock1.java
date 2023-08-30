package com.practice.Special.DP;

/**
 * rules:
 * 1) must buy then sell;
 * 2) at most 1 transaction is allowed
 */
public class BuySellStock1 {
    /**
     * iterative dp
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxCurr= 0; // the maximum value that can be achieved by picking up i, it may go up and down
        int maxSoFar = 0; // chery picking, used to snap the largest value in the ups and downs of maxCurr;
        for(int i = 1; i < prices.length; ++i) {
            maxCurr += prices[i] - prices[i - 1];

            // however, we have a limiter here: no negative is allowed
            maxCurr = Math.max(0, maxCurr);

            // cherry picking
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }
        return maxSoFar;
    }
}
