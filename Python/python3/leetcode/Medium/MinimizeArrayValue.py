# 2439. Minimize Maximum of Array
# Medium
# 2.3K
# 574
# Oracle
# company
# Paytm
# You are given a 0-indexed array nums comprising of n non-negative integers.
#
# In one operation, you must:
#
# Choose an integer i such that 1 <= i < n and nums[i] > 0.
# Decrease nums[i] by 1.
# Increase nums[i - 1] by 1.
# Return the minimum possible value of the maximum integer of nums after performing any number of operations.
#
#
#
# Example 1:
#
# Input: nums = [3,7,1,6]
# Output: 5
# Explanation:
# One set of optimal operations is as follows:
# 1. Choose i = 1, and nums becomes [4,6,1,6].
# 2. Choose i = 3, and nums becomes [4,6,2,5].
# 3. Choose i = 1, and nums becomes [5,5,2,5].
# The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
# Therefore, we return 5.
# Example 2:
#
# Input: nums = [10,1]
# Output: 10
# Explanation:
# It is optimal to leave nums as is, and since 10 is the maximum value, we return 10.
import unittest
from typing import List
import math
from itertools import accumulate

class MinimizeArrayValue:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        # the 1 indicates the starting index being 1
        # v: the accumulated value [0, 1, .., k]
        k = max(v / i for i, v in enumerate(accumulate(nums), 1))
        return math.ceil(k)

    # def minimizeArrayValue(self, nums: List[int]) -> int:
    #     mn = collections.max(nums)
    #     def dfs(nums, curr):
    #         for i in (1, len(nums)):
    #             if nums[i-1] < nums[i]:
    #                 nums[i-1] += 1
    #                 nums[i] -= 1
    #                 c = collections.max(nums)
    #                 if c < curr:
    #                     mn = min(mn, c)
    #                     dfs(nums, c)
    #                 nums[i-1] -= 1
    #                 num[i] += 1

    #     dfs(nums, mn)
    #     return mn

class TestMinimizeArrayValue(unittest.TestCase):
    sol = MinimizeArrayValue()

    def test_case1(self):
        heights = [3,7,1,6]
        expected = 5

        actual = self.sol.minimizeArrayValue(heights)
        self.assertEqual(expected, actual)

    def test_case2(self):
        heights = [10, 1]
        expected = 10

        actual = self.sol.minimizeArrayValue(heights)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
