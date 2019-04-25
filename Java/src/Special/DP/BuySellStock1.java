package Special.DP;

/**
 * rules:
 * 1) must buy then sell;
 * 2) at most 1 transaction is allowed
 */
public class BuySellStock1 {
    public int maxProfit1(int[] prices) {
        int maxCur = 0, // the maximum value that can be achieved by picking up i;
                maxSoFar = 0; // cheer picking handle
        for(int i = 1; i < prices.length; ++i) {
            maxCur += prices[i] - prices[i - 1];

            // however, we have a limiter here: no negative is guaranteed
            maxCur = Math.max(0, maxCur);

            // cheer picking
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
