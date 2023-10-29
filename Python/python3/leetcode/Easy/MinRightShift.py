from typing import List

class MinRightShift:
    def minimumRightShifts(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        if n == 1:
            return 0

        a = sorted(nums.copy())
        i = 1
        while a !=  nums:
            b = a[i:] + a[:i]
            a = b
        return i + 1





nums = [92,84,37,19,16,85,20,79,25,89]
nums = [3, 4, 5, 1, 2]
s = MinRightShift()

actual = s.minimumRightShifts(nums)
expected = -1
assert(expected == actual)