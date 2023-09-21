# 2371. Minimize Maximum Value in a Grid
import unittest
from typing import List

class MatrixMinScore:
    def minScore(self, grid: List[List[int]]) -> List[List[int]]:

        m, n = len(grid), len(grid[0])
        mpr, mpc = {}, {}

        # essentially flatten the grid into a list, with each element as (val, (i, j))
        vals_indexed = sorted([grid[i][j], (i, j)] for i in range(m) for j in range(n))
        res = [[0] * n for _ in range(m)]

        for val, (r, c) in vals_indexed:
            # try to pin down the right value, always starting from 1
            cur = 1
            if r in mpr and mpr[r] < val:
                cur = max(cur, mpr[r] + 1)
            if c in mpc and mpc[c] < val:
                cur = max(cur, mpc[c] + 1)

            mpr[r] = cur
            mpc[c] = cur

            res[r][c] = cur

        return res


class TestMatrixMinScore(unittest.TestCase):
    sol = MatrixMinScore()

    def test_case1(self):
        grid = [[3,1],[2,5]]
        expected = [[2,1],[1,2]]
        actual = self.sol.minScore(grid)
        self.assertEqual(expected, actual)

    def test_case2(self):
        grid = [[1, 3], [5, 10] , [9, 27]]
        expected = [[1, 2], [2, 3], [3, 4]]
        actual = self.sol.minScore(grid)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
