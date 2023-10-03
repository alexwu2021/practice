import sys
import functools
import sys, unittest
import itertools
from operator import mul

class Solution(unittest.TestCase):

         
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
        
