import sys
import functools
import sys, unittest
import itertools
from operator import mul

class Solution(unittest.TestCase):
    def maximumProduct_tle(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mp = {}
        n, mx = len(nums), -sys.maxsize
        for i in range(n-2):
            for j in range(i+ 1, n-1):
                for k in range(j+ 1, n):
                    if (i, j) not in mp:
                        mp[(i, j)] = nums[i] * nums[j]
                   
                    mx = max(mx, mp[(i, j)]  * nums[k])
        return mx
        
         
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        print('after sort, nums: %s' % nums)
        
        del nums[3:-3]
        print('after deletion, nums: %s' % nums)
        return max(functools.reduce(mul, c) for c in itertools.combinations(nums, 3))
    
    def test_maximumProduct(self):
        nums = [11, 2, 4, 5, 3, 23, 17, 8]
        res = self.maximumProduct(nums)
        print('nums: %s, res: %d' % (nums, res))
        res2 = self.maximumProduct_tle(nums)
        self.assertTrue(res == res2)


if __name__ == "__main__":
    unittest.main()
        
