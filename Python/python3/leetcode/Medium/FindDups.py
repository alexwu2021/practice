import unittest
from typing import List

# 287. Find the Duplicate Number
# Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
# There is only one repeated number in nums, return this repeated number.
# You must solve the problem without modifying the array nums and uses only constant extra space.
class FindDups:

    def findDuplicate_flip(self, nums: List[int]) -> int:
        nums.sort()
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                return nums[i]


    # utilize the property that elements can be indices
    # flip each element checked
    # if an element indexed in is found to be negative, then it has been flipped, implying that element is dup
    def findDuplicate_sort(self, nums: List[int]) -> int:
        for num in nums:
            cur = abs(num)
            if nums[cur] < 0:
                dup = cur
                break
            nums[cur] = -nums[cur]

        # optional
        for i in range(len(nums)):
            nums[i] = abs(nums[i])

        return dup

    def findDuplicate_set(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            if num in seen:
                return num
            seen.add(num)

    # slow fast
    def findDuplicate(self, nums):
        # Find the intersection point of the two runners.
        slow = fast = nums[0]
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        # Find the "entrance" to the cycle, where the entrance is the only outlier
        slow = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]

        return fast
class TestFindDups(unittest.TestCase):
    sol = FindDups()

    def test_case1(self):
        input = [1,3,4,2,2]
        expected = 2
        actual = self.sol.findDuplicate(input)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
