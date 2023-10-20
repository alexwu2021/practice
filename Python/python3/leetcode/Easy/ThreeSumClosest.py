from typing import List
import unittest
import sys

class ThreeSumClosest:

    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()

        n = len(nums)

        diff = sys.maxsize
        closest = sys.maxsize
        for i in range(n - 2):
            left, right = i + 1, n - 1
            while left < right:
                sm = nums[i] + nums[left] + nums[right]
                if abs(sm - target) < diff:
                    diff = abs(sm - target)
                    closest = sm
                if sm > target:
                    right -= 1
                elif sm < target:
                    left += 1
                else:
                    return sm
        return closest


assert(ThreeSumClosest().threeSumClosest([1, 1, 1, 0], 100) == 3)