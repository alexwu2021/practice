
from typing import List

class MaxProfit2:

    def maxProfit(self, A):
        if len(A) == 0:
            return 0
        k, n = 2, len(A)

        #   int dp[][] = new int[k][prices.length]; // dp[i][j] := max gains using up i credits and j days
        dp = [[0] * n for _ in range(k)]  # dp[i][j] := max gains using up i credits and j days

        for i in range(k):
            pre_deducted_max_contribution = float('-inf')
            for j in range(1, n):
                sub_gains = dp[i - 1][j - 1] if i > 0 else 0
                pre_deducted_max_contribution = max(pre_deducted_max_contribution, sub_gains - A[j - 1])
                dp[i][j] = max(dp[i][j - 1], A[j] + pre_deducted_max_contribution)
        return dp[k - 1][n - 1]


prices = [3,3,5,0,0,3,1,4]
actual = MaxProfit2().maxProfit(prices)
expected = 6
print("actual: %d" % actual)
assert(expected == actual)

prices = [1,2,3,4,5]
actual = MaxProfit2().maxProfit(prices)
print("actual: %d" % actual)
expected = 4
assert(expected == actual)

prices = [7,6,4,3,1]
actual = MaxProfit2().maxProfit(prices)
print("actual: %d" % actual)
expected = 0
assert(expected == actual)