from typing import List, Optional
import unittest
import itertools


class MaxTimeThatCanBeMade:
    def maxTimeThatCanBeMade(self, A : List[int]) -> int:
        temp = ["%d%d:%d%d" % t for t in itertools.permutations(A) if t[:2] < (2, 4) and t[2] < 6]
        return max(temp or [""])


class TestMaxTimeThatCanBeMade(unittest.TestCase):
    sol = MaxTimeThatCanBeMade()

    def test_case1(self):
        expected = "23:41"
        actual = self.sol.maxTimeThatCanBeMade([1, 2, 3, 4])
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
