package com.practice.Medium;

/**
 * # A salesman travel between two cities A and B to sell its product. On a particular day, he can either choose to sell the product or travel to other city. He cannot travel and sell on same day.
 * # We need to print the schedule of salesman for maximum profit earned.
 * #
 * # For example:
 * # Cost of selling product in city A: A = [23, 4, 5, 20]
 * # Cost of selling product in city B: B = [21, 1, 10 100]
 * #
 * # So max profit he can earn is by:
 * # Day1: Sell in City A (A)
 * # Day2: Travel to City B (T)
 * # Day3: Sell in City B (B)
 * # Day4: Sell in City B (B)
 * #
 * # Hence the answer should be "ATBB"
 * #
 * # Similar kind of problem with some addon https://leetcode.com/discuss/interview-question/762690/google-telephone-interview-coding-question.
 * # We need to account for travel and print the max profit schedule as String.
 */
public class MaxProfitSchedule {
    /**
     * pre-cond: A.length == B.length
     *
     * @param A
     * @param B
     * @return
     */
    public String maxProfitSchedule(int[] A, int[] B) {
        int n = A.length;

        // dp[day][city], 0 is A and 1 is B
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(A[i] + dp[i + 1][0], // stay
                    dp[i + 1][1]); // travel
            dp[i][1] = Math.max(B[i] + dp[i + 1][1], // stay
                    dp[i + 1][0]  // travel
            );
        }

        StringBuilder sb = new StringBuilder();
        int currentCity = (dp[0][0] > dp[0][1]) ? 0 : 1;

        for (int j = 0; j < n; ++j) {
            if (currentCity == 0) {
                if (A[j] + dp[j + 1][0] > dp[j + 1][1]) { // stay
                    sb.append('A');
                } else {
                    sb.append('T');
                    currentCity = 1;
                }
            } else {
                if (B[j] + dp[j + 1][1] > dp[j + 1][0]) {
                    sb.append('B');
                } else {
                    sb.append('T');
                    currentCity = 0;
                }
            }
        }

        return sb.toString();
    }
}
