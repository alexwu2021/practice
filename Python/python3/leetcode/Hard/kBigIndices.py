
import unittest
from sortedcontainers import SortedList
from typing import List

class KBigIndices:
    def kBigIndices(self, nums: List[int], k: int) -> int:
        smaller, bigger = SortedList(), SortedList(nums)
        res = 0
        for n in nums:
            bigger.remove(n)
            if smaller.bisect_left(n) >= k and bigger.bisect_left(n) >= k:
                res += 1
            smaller.add(n)
        return res

    def kBigIndices_index_based(self, nums: List[int], k: int) -> int:
        sl1,sl2 = SortedList(),SortedList(nums)
        res = 0
        for i in range(len(nums)):
            sl2.remove(nums[i])
            if sl1.bisect_left(nums[i]) >= k and sl2.bisect_left(nums[i]) >= k:
                res += 1
            sl1.add(nums[i])
        return res

class TestKBigIndices(unittest.TestCase):
    sol = KBigIndices()

    def test_case1(self):
        nums = [2,3,6,5,2,3]
        k = 2
        expected = 2

        actual = self.sol.kBigIndices(nums, k)
        self.assertEqual(expected, actual)

    def test_case2(self):
        nums = [1, 1, 1]
        k = 3
        expected = 0

        actual = self.sol.kBigIndices(nums, k)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
