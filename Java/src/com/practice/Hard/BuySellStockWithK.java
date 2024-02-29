package com.practice.Hard;

public class BuySellStockWithK {

    public int maxProfit(int[] prices) {
        if(prices.length ==0)
            return 0;

        int k=2;
        int dp[][] = new int[k][prices.length]; // dp[i][j] := max gains using up i credits and j days

        for (int i = 0; i < dp.length; ++i) {
            int preDeductedMaxContribution = Integer.MIN_VALUE;
            for (int j = 1; j < dp[0].length; ++j) {
                int subGains = i > 0 ? dp[i - 1][j - 1] : 0;
                preDeductedMaxContribution = Math.max(preDeductedMaxContribution,  subGains - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + preDeductedMaxContribution);
            }
        }
        return dp[k-1][prices.length - 1];
    }
}
