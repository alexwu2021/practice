from typing import List

class IsMonotonic:

    def isMonotonic(self, A: List[int]) -> bool:
        return all(A[i] <= A[i+1] for i in range(len(A) - 1)) or all(A[i] >= A[i+1] for i in range(len(A) - 1))
    def isMonotonic_little_bit_faster(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 2: return True

        i = 1
        while i < n and nums[i] == nums[i - 1]:
            i += 1
        if i >= n - 1:
            return True

        monotonic = True if nums[i] > nums[i - 1] else False
        for j in range(i + 1, len(nums)):
            if nums[j] > nums[j - 1] and not monotonic:
                return False
            if nums[j] < nums[j - 1] and monotonic:
                return False
        return True


nums = [1,1, 1]
actual = IsMonotonic().isMonotonic(nums)
expected = True
assert(expected == actual)

nums = [1,3,2,4]
actual = IsMonotonic().isMonotonic(nums)
expected = False
assert(expected == actual)


nums = [6,5,4,4]
actual = IsMonotonic().isMonotonic(nums)
expected = True
assert(expected == actual)

