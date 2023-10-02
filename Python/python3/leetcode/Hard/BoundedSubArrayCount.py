# 2444. Count Subarrays With Fixed Bounds
# You are given an integer array nums and two integers minK and maxK.
# A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
# The minimum value in the subarray is equal to minK.
# The maximum value in the subarray is equal to maxK.
# Return the number of fixed-bound subarrays.

from typing import List

class BoundedSubArrayCount:

    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans = 0
        mi = xi = bi = -1
        for i in range(len(nums)):
            if nums[i] > maxK or nums[i] < minK:
                bi = i
            if nums[i] == minK:
                mi = i
            if nums[i] == maxK:
                xi = i
            ans += max(0, min(mi, xi) - bi)
        return ans

    def countSubarrays_masters(self, A: List[int], minK: int, maxK: int) -> int:
        res = 0
        jmin = jmax = jbad = -1
        for i, a in enumerate(A):
            if not minK <= a <= maxK: jbad = i
            if a == minK: jmin = i
            if a == maxK: jmax = i
            res += max(0, min(jmin, jmax) - jbad)
        return res


