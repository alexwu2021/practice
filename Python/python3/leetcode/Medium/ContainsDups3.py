# 220
import unittest
from typing import List

class ContainsDups3:
    def containsNearbyAlmostDuplicate(self, nums: List[int], indexDiff: int, valueDiff: int) -> bool:
        if valueDiff < 0: return False  # edge case

        seen = {}
        for i, x in enumerate(nums):
            bucket = x // (valueDiff + 1)
            if bucket in seen and i - seen[bucket][0] <= indexDiff: return True
            if bucket - 1 in seen and i - seen[bucket - 1][0] <= indexDiff and abs(x - seen[bucket - 1][1]) <= valueDiff: return True
            if bucket + 1 in seen and i - seen[bucket + 1][0] <= indexDiff and abs(x - seen[bucket + 1][1]) <= valueDiff: return True
            seen[bucket] = (i, x)
        return False
def containsNearbyAlmostDuplicate(self, nums: List[int], indexDiff: int, valueDiff: int) -> bool:
        def dfs(nums, s, id, vd):
            for j in range(s + 1, min(s+id + 1,  len(nums))):
                if abs(nums[j] - nums[s]) <= vd:
                    return True
            return False

        for i in range(0, len(nums) - indexDiff + 1):
            if dfs(nums, i, indexDiff, valueDiff):
                return True
        return False


class TestContainsDups3(unittest.TestCase):
    sol = ContainsDups3()

    def test_case1(self):
        input = [1,5,9,1,5,9]
        indexDiff = 2
        valueDiff = 3
        actual = self.sol.containsNearbyAlmostDuplicate(input, indexDiff, valueDiff)
        self.assertFalse(actual)

    def test_case2(self):
        input = [1,2,3,1]
        indexDiff = 3
        valueDiff = 0
        actual = self.sol.containsNearbyAlmostDuplicate(input, indexDiff, valueDiff)
        self.assertTrue(actual)

    def test_case3(self):
        input = [2, 2]
        indexDiff = 2
        valueDiff = 0
        actual = self.sol.containsNearbyAlmostDuplicate(input, indexDiff, valueDiff)
        self.assertTrue(actual)

    def test_case4(self):
        input = [4,1,-1,6,5]
        indexDiff = 3
        valueDiff = 1
        actual = self.sol.containsNearbyAlmostDuplicate(input, indexDiff, valueDiff)
        self.assertTrue(actual)



if __name__ == '__main__':
    unittest.main()
