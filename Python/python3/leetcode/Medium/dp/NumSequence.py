class NumSequence:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)

        dp = [[0] * (n + 1) for _ in range(m + 1)]
        # dp[r][c] number of distinct sequence, matching [0..c] of t, made from [0..r] of s

        for r in range(m + 1):
            dp[r][0] = 1 # always there is one way to make an empty sequence, as indicated by the scala 0

        for r in range(1, m + 1):
            for c in range(1, n + 1):
                dp[r][c] += dp[r - 1][c]
                if s[r - 1] == t[c - 1]:
                    dp[r][c] += dp[r - 1][c - 1]

        return dp[-1][-1]