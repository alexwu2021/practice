import unittest
from functools import cache

from typing import List

class MinOperationsToZero:

    def minOperations(self, nums: List[int], x: int) -> int:
        target = sum(nums) - x
        curr_sum, max_len = 0, 0
        found = False
        s = 0

        for e in range(len(nums)):
            curr_sum += nums[e]

            # subtract if possible
            while s <= e and curr_sum > target:
                curr_sum -= nums[s]
                s += 1
            if curr_sum == target:
                found = True
                max_len = max(max_len, e - s + 1)

        return len(nums) - max_len if found else -1
    def minOperations_tle(self, nums: List[int], x: int) -> int:
        @cache
        def dfs(nums, y, count, left, right):
            if y == 0: return count
            if y < 0 or left > right: return -1
            left_val = dfs(nums, y - nums[left], count + 1, left + 1, right)
            right_val = dfs(nums, y - nums[right], count + 1, left, right - 1)
            if left_val < 0 and right_val > 0: return right_val
            if left_val > 0 and right_val < 0: return left_val
            return min(left_val, right_val)

        return dfs(nums, x, 0, 0, len(nums) - 1)

class TestMinOperationsToZero(unittest.TestCase):
        sol = MinOperationsToZero()


# Example 1:
        #
        # Input: nums = [1,1,4,2,3], x = 5
        # Output: 2
        # Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
        # Example 2:
        #
        # Input: nums = [5,6,7,8,9], x = 4
        # Output: -1
        # Example 3:
        #
        # Input: nums = [3,2,20,1,1,3], x = 10

        def test_case1(self):
            nums = [1,1,4,2,3]
            x = 5
            expected = 2
            actual = self.sol.minOperations(nums, x)
            self.assertEqual(expected, actual)

        def test_case2(self):
            nums = [5,6,7,8,9]
            x = 4
            expected = -1
            actual = self.sol.minOperations(nums, x)
            self.assertEqual(expected, actual)

        def test_case3(self):
            nums = [3,2,20,1,1,3]
            x = 10
            expected = 5
            actual = self.sol.minOperations(nums, x)
            self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
