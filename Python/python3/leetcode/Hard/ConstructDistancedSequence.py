# 1718. Construct the Lexicographically Largest Valid Sequence
import unittest
from typing import List


class ConstructDistancedSequence:
    def construct_distanced_sequence(self, n: int) -> List[int]:
        res = [0] * (n * 2 - 1)
        v = set()

        def dfs(idx):
            if len(v) == n:  # all used up
                return res

            if res[idx]:
                return dfs(idx + 1)

            for x in range(n, 0, -1):
                if x in v:
                    continue

                sec = idx + x  # the second index of x, so x has two {idx, sec}
                if x == 1:  # only 1 "1" is allowed
                    sec = idx

                if sec < len(res) and res[idx] == res[sec] == 0:
                    res[idx] = res[sec] = x
                    v.add(x)
                    a = dfs(idx + 1)
                    if a:
                        return a

                    # tailspin
                    v.remove(x)
                    res[idx] = res[sec] = 0
            return []

        return dfs(0)


class TestConstructDistancedSequence(unittest.TestCase):
    sol = ConstructDistancedSequence()

    def test_1(self):
        n = 3
        expected = [3, 1, 2, 3, 2]  # Explanation: [2, 3, 2, 1, 3] is valid, but only [3, 1, 2, 3, 2] is the lexicographically largest valid sequence.
        actual = self.sol.construct_distanced_sequence(n)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
