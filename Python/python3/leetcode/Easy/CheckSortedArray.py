from typing import List



class CheckSortedArray:
    def check_speed(self, nums: List[int]) -> bool:
        if not nums or len(nums) <= 2:
            return True

        i = 0
        count = 0
        while i < len(nums):
            if nums[i % len(nums)] < nums[(i - 1)]:
                count += 1
            i += 1
        return count <= 1

    def check(self, A):
        return sum(a > b for a, b in zip(A, A[1:] + A[:1])) <= 1