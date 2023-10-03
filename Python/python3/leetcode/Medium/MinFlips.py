import itertools
import unittest

class MinFlips:

    def minFlips(self, A: str) -> int:
        return len(list(itertools.groupby(A.lstrip('0'))))

    def minFlips_explainable(self, target):
        res = 0
        for c in target:
            if res % 2 != int(c):
                res += 1
        return res

    def minFlips_cleaner(self, target):
        res = 0
        n = len(target)
        for i in range(n):
            if (res % 2 == 0 and target[i] == '1') or (res % 2 == 1 and target[i] == '0'):
                res += 1
        return res

class TestMinFlips(unittest.TestCase):
    sol = MinFlips()

    def test_case1(self):
        target = "10111"
        expected = 3
        actual = self.sol.minFlips(target)
        actual = self.sol.minFlips_cleaner(target)
        self.assertEqual(expected, actual)

    def test_case2(self):
        target = "101"
        expected = 3
        actual = self.sol.minFlips(target)
        self.assertEqual(expected, actual)

    def test_case3(self):
        target = "00000"
        expected = 0
        actual = self.sol.minFlips(target)
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()