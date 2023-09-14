# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):
import sys
class Solution(object):
    #accepted
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = -sys.maxsize
        low, high = 1, n
        while low <= high:
            mid = low + (high-low) // 2
            g = guess(mid)
            if g == 0:
                res = mid
                break
            elif g < 0:
                high = mid -1
            else:
                low = mid + 1
        return res
            
        