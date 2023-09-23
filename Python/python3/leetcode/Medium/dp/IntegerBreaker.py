# 343. Integer Breaker: find the max product of more than 2 constituent parts of a given integer

from functools import cache

class IntegerBreaker:
    def integerBreak(self, n: int) -> int:
        @cache
        def dp(num):
            # base case
            if num <= 3:
                return num

            ans = 1
            for i in range(2, num):
                ans = max(ans, i * dp(num - i)) # the current i is a qualified constituent, and sub prob is dp(num-i)
            return ans

        # necessary, otherwise, it will fail on n = 2
        if n <= 3:
            return n - 1
        return dp(n)
