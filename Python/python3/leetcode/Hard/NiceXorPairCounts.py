# 1803. Count Pairs With XOR in a Range

import unittest
from typing import List
from functools import cache
from collections import Counter

class NiceXorPairCounts:

    def countPairs(self, A: List[int], low: int, high: int) -> int:
        count = Counter(A)
        high += 1
        res = 0
        while high:
            if high & 1:
                next = high - 1
                res += sum(count[c] * count[next ^ c] for c in count)

            if low & 1:
                next = low - 1
                res -= sum(count[c] * count[next ^ c] for c in count)

            count = Counter({c >> 1: count[c] + count[c ^ 1] for c in count})

            high >>= 1
            low >>= 1
        return res // 2



    # lee215 way
    def countPairs(self, nums: List[int], low: int, high: int) -> int:
        def test(A, x):
            count = Counter(A)
            res = 0
            while x:
                if x & 1:
                    res += sum(count[a] * count[(x - 1) ^ a] for a in count)
                count = Counter({a >> 1: count[a] + count[a ^ 1] for a in count})
                x >>= 1
            return res // 2

        return test(nums, high + 1) - test(nums, low)

    def countPairs_simpleCachingTle(self, nums: List[int], low: int, high: int) -> int:
        @cache
        def nice(a, b, l, h):
            c = a ^ b
            return c >= l and c <=h

        ans = set()
        for i in range(0, len(nums) -1):
            for j in range(i + 1, len(nums)):
                if nice(nums[i], nums[j], low, high):
                    ans.add((i, j))
        return len(ans)




class TestNiceXorPairCounts(unittest.TestCase):
    sol = NiceXorPairCounts()

    def test_case1(self):
        input = [1,4,2,7]
        low, high = 2, 6
        expected = 6
        actual = self.sol.countPairs(input, low, high)
        # actual = self.sol.countPairs_simpleCachingTle(input, low, high)
        self.assertEqual(expected, actual)




if __name__ == '__main__':
    unittest.main()
