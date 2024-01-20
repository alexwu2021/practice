
# You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
#
# The length of the subarray is k, and
# All the elements of the subarray are distinct.
# Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

from typing import List
from collections import Counter

class MaximumSubarraySum:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:

        seen = Counter(nums[:k])
        sm = sum(nums[:k])

        ans = 0
        if len(seen) == k:
            ans = sm

        for i in range(k, len(nums)):
            sm += nums[i] - nums[i - k]
            seen[nums[i]] += 1
            seen[nums[i - k]] -= 1

            if seen[nums[i - k]] == 0:
                del seen[nums[i - k]]

            if len(seen) == k:
                ans = max(ans, sm)

        return ans


#
#
#
nums = [9,5,9,1,2,3]
k = 3
expected = 15
actual = MaximumSubarraySum.maximumSubarraySum(nums, k)
assert(actual == expected)



nums = [1,5,4,2,9,9,9]
k = 3
expected = 15
actual = MaximumSubarraySum.maximumSubarraySum(nums, k)
assert(actual == expected)


nums = [1,1,1,7,8,9]
k = 3
expected = 24
actual = MaximumSubarraySum.maximumSubarraySum(nums, k)
assert(actual == expected)

nums = [4, 4, 4]
k = 3
expected = 0
actual = MaximumSubarraySum.maximumSubarraySum(nums, k)
assert(actual == expected)