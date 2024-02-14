import math

class DiceRolling:

    def distinctSequences(self, n: int) -> int:
        dp = [[[0] * 7 for _ in range(7)] for _ in range(10001)]

        def dfs(n, pp, p):
            nonlocal dp
            if n == 0:
                return 1
            if dp[n][pp][p] == 0:
                for d in range(1, 7):
                    if d != p and d != pp and (pp == 0 or math.gcd(d, pp) == 1):
                        dp[n][pp][p] = (dp[n][pp][p] + dfs(n - 1, d, pp)) % ((10 ** 9) + 7)
            return dp[n][pp][p]

        return dfs(n, 0, 0)