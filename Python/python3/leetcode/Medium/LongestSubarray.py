from typing import List
from collections import deque
import unittest
class LongestSubarry:

    # no dp!!
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        res = 1
        asc, desc = deque([0]), deque([0])
        left, right = 0, 0
        for right in range(1, len(nums)):
            while asc and nums[asc[-1]] > nums[right]:
                asc.pop()
            asc.append(right)

            while desc and nums[desc[-1]] < nums[right]:
                desc.pop()
            desc.append(right)
            while nums[desc[0]] - nums[asc[0]] > limit:
                left += 1
                if desc[0] < left:
                    desc.popleft()
                if asc[0] < left:
                    asc.popleft()

            res = max(res, right - left + 1)
        return res



l = LongestSubarry()
nums = [4,2,2,2,4,4,2,2]
k = 0
actual = l.longestSubarray(nums, k)
expected = 3
print("actual: %d " % actual)
assert(expected == actual)