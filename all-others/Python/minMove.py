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
        

#to avoid overflow
public class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }
}
