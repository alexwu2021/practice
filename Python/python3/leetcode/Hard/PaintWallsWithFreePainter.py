from typing import List
from math import inf

# 2742. Painting the Walls
# You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to paint n different walls respectively. There are two painters available:
# A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
# A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the paid painter is already occupied.
# Return the minimum amount of money required to paint the n walls.
class PaintWallsWithFreePainter:

    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        n = len(cost)
        dp = [[0] * (n + 1) for _ in range(n + 1)]

        # dp[i][j] to paint [i..n] walls with j time unit allocated

        for d in range(1, n + 1): dp[n][d] = inf

        for i in range(n - 1, -1, -1):
            for remain_time_unit in range(1, n + 1): # at each ith time unit, we have this remaining time units, complement to n
                dont_paint = dp[i + 1][remain_time_unit] # let the free painter not paint

                # let them together do the jobs [i+1...n], expecting our time budget drop to  remain_time_unit - time[i] - 1 but no negative
                # the free painter eats away 1 time unit
                time_budget = max(0, remain_time_unit - time[i] - 1)
                paint = cost[i] + dp[i + 1][time_budget]

                dp[i][remain_time_unit] = min(paint, dont_paint)

        return dp[0][n]


