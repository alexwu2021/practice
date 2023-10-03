#Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
# sum + (n-1) * m = x * n, where x =  minNum + m, where m is the number of moves, x is the final number in each cell
# sum + mn - m = minNum * n +  mn
# sum -m = minNum * n
# m = sum - minNum * n

import sys

class Solution:
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        s, mn, n =0, sys.maxsize, len(nums)
        for i in range(n):
            s += nums[i]
            mn = min(mn, nums[i])            
        return s - mn * n
