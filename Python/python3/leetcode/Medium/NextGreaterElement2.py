import unittest
from typing import List
class NextGreaterElement2:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # stack holds increasing indices
        ## 2. In the first loop, smoe NGE will be identified and set, but not all.
        ## 3. In the second loop, there might be some elements left in the stack, so we iterate again (without appending to stack) and get NGE
        ## 4. The elements that are left in the stack even after second loop are max(nums).
        stack, ans = [], [-1] * len(nums)
        for i, v in enumerate(nums):
            while stack and nums[stack[-1]] < v:
                ans[stack.pop()] = v
            stack.append(i)
        for i, v in enumerate(nums):
            while stack and nums[stack[-1]] < v:
                ans[stack.pop()] = v
        return ans

nums = [1, 2, 1]
assert(NextGreaterElement2().nextGreaterElements(nums) == [2, -1, 2])

