import sys
class StrangePrinter:

    # implemented gm's
    def strangePrinter(self, s: str) -> int:
        if not s or len(s) <= 0: return 0
        n = len(s)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for i in range(n-1, -1, -1):
            for d in range(1, n-i):
                j = i + d
                if d == 1:
                    dp[i][j] = 2 - (s[i] == s[j])
                    continue
                dp[i][j] = sys.maxsize
                for k in range(i, j):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
                dp[i][j] -= (s[i] == s[j])  # this is easy to forget corner case: decrement if head and tail are of the same char
        return dp[0][n-1]
