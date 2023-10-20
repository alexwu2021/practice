from typing import List

# 718. Maximum Length of Repeated Subarray
# Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

class LengthOfCommonSubArrays:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        m, n = len(nums1), len(nums2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        ans = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # dp[i][j] = dp[i-1][j-1]   # attention: do not do this
                if nums1[i - 1] == nums2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    ans = max(ans, dp[i][j])
        return ans
