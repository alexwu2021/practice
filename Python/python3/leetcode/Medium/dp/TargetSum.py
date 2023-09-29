# 494

from typing import List
import unittest

# You are given an integer array nums and an integer target.
# You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
# For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
# Return the number of different expressions that you can build, which evaluates to target.

class TargetSum:


    def findTargetSumWays_dp(self, nums: List[int], target: int) -> int:
        totalSum = sum(nums)
        if target not in range(-1 * totalSum, totalSum + 1):
            return 0

        dp = [[0 for j in range(totalSum * 2 + 1)] for i in range(len(nums))]
        dp[0][totalSum + nums[0]] += 1
        dp[0][totalSum - nums[0]] += 1

        for i in range(1, len(nums)):
            for j in range(totalSum * 2 + 1):

                if j - nums[i] >= 0 and dp[i - 1][j - nums[i]] > 0:  # left side
                    dp[i][j] += dp[i - 1][j - nums[i]]

                if j + nums[i] <= totalSum * 2 and dp[i - 1][j + nums[i]] > 0:  # right side
                    dp[i][j] += dp[i - 1][j + nums[i]]

        return dp[-1][totalSum + target]



    def findTargetSumWays(self, nums: List[int], target: int) -> int:

        # no need to pass index, for we can infer where we are by curr
        def dfs(curr, nums):
            if not nums:
                return 1 if curr == target else 0

            key = (curr, tuple(nums))
            if key in ccache:
                return ccache[key]

            res = dfs(curr - nums[0], nums[1:]) + dfs(curr + nums[0], nums[1:])
            ccache[key] = res
            return res

        ccache = {}
        return dfs(0, nums)


class TestTargetSum(unittest.TestCase):
    sol = TargetSum()

    def test_case1(self):
        nums = [1, 1, 1, 1, 1]
        target = 3
        expected = 5
        actual = self.sol.findTargetSumWays(nums, target)
        self.assertEqual(expected, actual)




if __name__ == '__main__':
    unittest.main()

