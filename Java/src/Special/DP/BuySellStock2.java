package Special.DP;

/**
 * rules:
 * 1) must buy then sell;
 * 2) multiple transactions allowed; // this is different from  BuySellStock1
 * 3) consecutive buys or sales are prohibited.
 */
public class BuySellStock2 {


    public int maxProfit2(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            // an interesting note: we must use equal sign below
            // otherwise the program will hang if the input is like {1, 1}
            while (i < N && prices[i] >= prices[i + 1]) i++;
            buy = prices[i];

            while (i < N && prices[i] < prices[i + 1]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

}
