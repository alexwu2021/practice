# 1852. Distinct Numbers in Each Subarray
import collections
import unittest
from typing import List, Set

class DistinctNumbersInEachSubarray:

    def distinctNumbers(self, nums: List[int], k: int) -> List[int]:
        c = collections.Counter(nums[:k])
        cur = len(c)
        ans = [cur]

        for i in range(k, len(nums)):

            c[nums[i - k]] -= 1

            if c[nums[i - k]] == 0:
                cur -= 1
            if c[nums[i]] == 0:
                cur += 1
            c[nums[i]] += 1

            ans.append(cur)
        return ans

    def distinctNumbers_naive(self, nums: List[int], k: int) -> List[int]:
        ans = []
        j = 0
        for i in range(k-1, len(nums)):
            ans.append(len(set(nums[j:i+1])))
            j = j + 1
        return ans


class TestDistinctNumbersInEachSubarray(unittest.TestCase):
    sol = DistinctNumbersInEachSubarray()
    # Input: nums = [1, 2, 3, 2, 2, 1, 3], k = 3
    # Output: [3, 2, 2, 2, 3]
    def test_case_1(self):
        input = [1, 2, 3, 2, 2, 1, 3]
        k = 3
        actual = self.sol.distinctNumbers(input, k)
        expected = [3, 2, 2, 2, 3]
        self.assertEqual(expected, actual)


    # Input: nums = [1, 2, 3, 2, 2, 1, 3], k = 3
    # Output: [3, 2, 2, 2, 3]
    def test_case_2(self):
        input = [1, 1, 1, 1, 2, 3, 4]
        k = 4
        actual = self.sol.distinctNumbers(input, k)
        expected = [1, 2, 3, 4]
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()


