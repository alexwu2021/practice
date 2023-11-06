# You are given a 0-indexed array of integers nums, and an integer target.
#
# Return the length of the longest subsequence of nums that sums up to target. If no such subsequence exists, return -1.
#
# A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

from typing import List
class LongestSubsequenceSumToK:
    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        dp = [0] * (target + 1)  # dp[k] := subsequence length that sums up to k

        for num in nums:
            t = target
            while t >= num:
                if dp[t - num] == 0:
                    dp[t] = max(dp[t], 1 + dp[t-num])
                elif dp[t - num] > 0:
                    dp[t] = max(dp[t], 1 + dp[t-num])
                t -= 1
        return -1 if not dp[target] else dp[target]




nums = [1,2,3,4,5]
target = 9
actual = LongestSubsequenceSumToK().lengthOfLongestSubsequence(nums, target)
expected = 3
assert(expected == actual)
