import unittest
from typing import List


class SubarraySum:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ans = 0
        psum_counter = {0: 1}
        psum = 0
        for num in nums:
            psum += num
            psum_counter[psum] = psum_counter.get(psum, 0) + 1
            if psum - k in psum_counter:
                ans += psum_counter[psum - k]
        return ans




    # presum = [0] * (n + 1)
    # for i in range(1, n + 1):
    #     presum[i] += presum[i - 1] + nums[i - 1]
    # dp = [[0] * n for _ in range(n)]
    # for i in range(n):
    #     for j in range(i, n):
    #         if j >= 1:
    #             dp[i][j] += dp[i][j - 1]
    #         if presum[j + 1] - presum[i] == k:
    #             dp[i][j] += 1
    #         if j == i and nums[i] == k:
    #             dp[i][j] += 1
    # return dp[n - 1][n - 1]


assert (SubarraySum().subarraySum([1, 1, 1], 2) == 2)

assert (SubarraySum().subarraySum([1, 2, 3], 3) == 2)
