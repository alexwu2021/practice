class Solution:
    def lastStoneWeightII(self, stones):
        n, total = len(stones), sum(stones)
        mid = total // 2
        dp = [[0] * (mid + 1) for _ in range(n + 1)] # best gains from bagging first i items into a bag of size j
        for i in range(1, n + 1):
            for j in range(mid + 1):
                if j >= stones[i - 1]:
                    dp[i][j] = max(dp[i - 1][j],  stones[i - 1] + dp[i - 1][j - stones[i - 1]])
                else:
                    dp[i][j] = dp[i - 1][j]
        return total - 2 * dp[n][mid]

