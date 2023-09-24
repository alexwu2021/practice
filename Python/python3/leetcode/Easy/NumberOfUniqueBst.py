# 96
# Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
class NumberOfUniqueBst:

    # G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = dp[1] = 1

        for i in range(2, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]  # the prod of

        return dp[n]
