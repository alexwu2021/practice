import unittest
from typing import List

class SearchInsertPosition:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == nums[mid]:
                return mid
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return left

class TestMaximumLengthOfConcatenatedStrings(unittest.TestCase):
    sol = SearchInsertPosition()

    def test_hit(self):
        input = [1, 2, 3, 5]
        target = 3
        actual = self.sol.searchInsert(input, target)
        expected = 2
        self.assertEqual(expected, actual)

    def test_miss(self):
        input = [1, 2, 5, 6]
        target = 2
        actual = self.sol.searchInsert(input, target)
        expected = 1
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()


