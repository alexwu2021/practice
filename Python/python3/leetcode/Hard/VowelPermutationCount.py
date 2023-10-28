class VowelPermutationCount:
    def countVowelPermutation(self, n: int) -> int:
        dp = [[0] * 5 for _ in range(n + 1)]
        dp[1] = [1, 1, 1, 1, 1]
        for i in range(2, n + 1):
            # a is allowed to follow e, i, or u.
            dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]
            # e is allowed to follow a or i.
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
            # i is allowed to follow e or o.
            dp[i][2] = dp[i - 1][1] + dp[i - 1][3]
            # o is allowed to follow i
            dp[i][3] = dp[i - 1][2]
            # u is allowed to follow i or o.
            dp[i][4] = dp[i - 1][2] + dp[i - 1][3]
        return sum(dp[n]) % ((10 ** 9) + 7)