import sys

class Solution:
    #simple dp problem, and this is accepted
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        if cost is None:
            return sys.maxsize
        size = len(cost)
        if size == 0:
            return sys.maxsize
        if size == 1:
            return cost[0]
        
        p, c = cost[0], cost[1]
        for i in range(2, size):
            p, c  = c, min(c, p) + cost[i]
        return min(p, c)
