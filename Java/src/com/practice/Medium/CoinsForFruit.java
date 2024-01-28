package com.practice.Medium;

import java.util.Arrays;

/**
 * 2944
 */
public class CoinsForFruit {

        private int[][] memo;
        public int minimumCoins(int[] prices) {
            memo = new int[prices.length][prices.length+1];
            for (int[] row : memo)
                Arrays.fill(row, -1);
            return dfs(prices, 0, 0);
        }

        public int dfs(int[] prices, int i, int freebies) {
            if (i >= prices.length) {
                return 0;
            }

            if (memo[i][freebies] != -1) {
                return memo[i][freebies];
            }

            int notTake = dfs(prices, i+1, i+1) + prices[i];
            if(freebies == 0){
                return memo[i][freebies] = notTake;
            }

            int take = dfs(prices, i+1, freebies-1);
            return memo[i][freebies] = Math.min(notTake, take);
        }


//    private int minCost = Integer.MAX_VALUE;
//    public int minimumCoins_uncompleted(int[] prices) {
//        if(prices.length <= 2) return prices[0];
//
//        dfs(prices[0], prices, 1, false);
//        return this.minCost;
//    }
//
//    private void dfs(int cost, int[] prices, int i, boolean mustBuy) {
//        if(i >= prices.length){
//            this.minCost = Math.min(this.minCost, cost);
//            return;
//        }
//
//        if(mustBuy){
//            dfs(cost + prices[i], prices, i+1, false);
//        }else{
//            dfs(cost, prices, i+ i , true);
//            dfs(cost + prices[i], prices, i+1, false);
//        }
//    }
}
