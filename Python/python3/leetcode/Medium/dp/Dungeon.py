
from typing import List
import sys
class Dungeon:
    def calculateMinimumHP(self, A: List[List[int]]) -> int:
        m, n = len(A), len(A[0])
        mx = sys.maxsize
        dp = [[mx] * n for _ in range(m)]

        for r in range(m - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                if A[r][c] > 0:
                    dp[r][c] = 0
                    if r + 1 < m and c + 1 < n:
                        dp[r][c] = min(abs(dp[r + 1][c] - A[r][c]), abs(dp[r][c + 1] - A[r][c]))
                    elif r + 1 < m:
                        if A[r][c] > dp[r + 1][c]:
                            dp[r][c] = 0
                        else:
                            dp[r][c] = dp[r + 1][c] - A[r][c]
                    elif c + 1 < n:
                        if A[r][c] > dp[r][c + 1]:
                            dp[r][c] = 0
                        else:
                            dp[r][c] = dp[r][c + 1] - A[r][c]

                else:
                    dp[r][c] = -A[r][c] + 1
                    if r + 1 < m and c + 1 < n:
                        dp[r][c] = min(dp[r + 1][c] + dp[r][c], dp[r][c + 1] + dp[r][c])
                    elif r + 1 < m:
                        dp[r][c] += dp[r + 1][c]
                    elif c + 1 < n:
                        dp[r][c] += dp[r][c + 1]

                # print("[]r: %d, c: %d] %d" % (r, c, dp[r][c]))
        return dp[0][0]


d = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
actual = Dungeon().calculateMinimumHP(d)
expected = 7
assert(expected == actual)