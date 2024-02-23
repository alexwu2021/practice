from typing import List

class BestTimeToBuySellStock2:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [0] * (n)
        if prices[n - 2] < prices[n - 1]:
            dp[n - 2] = prices[n - 1] - prices[n - 2]
        for i in range(n - 3, -1, -1):
            dp[i] = dp[i + 1]
            for j in range(i + 1, n):
                temp = 0
                if prices[j] > prices[i]:
                    temp = prices[j] - prices[i]
                    dp[i] = max(dp[i], temp)
                if j + 2 < n and dp[j + 2] > 0:
                    dp[i] = max(dp[i], temp + dp[j+2])

        return dp[0]



prices = [1,2,3,0,2]
actual = BestTimeToBuySellStock2().maxProfit(prices)
expected = 3
assert(expected == actual)