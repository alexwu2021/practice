import sys
from functools import cache
from typing import List
import unittest

class StickProblem:

    def find_min_num_of_sticks_to_make_the_number_dp(self, S: List[int], n: int) -> int:
        m = len(S)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # dp[i][j]: the minimal number of sticks used to make a value of i
        for row in range(1, n + 1):
            dp[0][row] = sys.maxsize

        for col in range(1, n + 1):
            for row in range(1, m + 1):
                if (S[row - 1] > col):
                    dp[row][col] = dp[row - 1][col]
                else:
                    dp[row][col] = min(dp[row - 1][col], dp[row][col - S[row - 1]] + 1)

        return dp[m][n] if dp[m][n] < sys.maxsize else -1

    def find_min_num_of_sticks_to_make_the_number_dp2(self, S: List[int], n: int) -> int:
        m = len(S)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for c in range(1, n + 1):
            dp[0][c] = sys.maxsize

        for r in range(1, n + 1):
            for c in range(1, m + 1):
                if (S[c - 1] > r):
                    dp[c][r] = dp[c - 1][r]
                else:
                    dp[c][r] = min(dp[c - 1][r], dp[c][r - S[c - 1]] + 1)

        return dp[m][n] if dp[m][n] < sys.maxsize else -1




    def find_min_num_of_sticks_to_make_the_number(self, sticks: List[int], num_to_make: int) -> int:
        def dfs(idx, curr, remaining):
            # good base case
            if remaining == 0:
                return len(curr)

            # bad base cases
            if remaining < 0 or idx < 0:
                return sys.maxsize


            # skip the current number referred by idx in sticks
            do_not_use = dfs(idx - 1, curr, remaining)

            # use the current number referred by idx in sticks
            curr.append(sticks[idx - 1])
            use = dfs(idx, curr, remaining - sticks[idx - 1])
            curr.pop(len(curr) - 1)

            return min(do_not_use, use)

        res = dfs(len(sticks), [], num_to_make)
        return res if res < sys.maxsize else -1


class TestStickProblem(unittest.TestCase):
    sol = StickProblem()

    def test_case1(self):
        K = 13
        Sticks = [1, 5, 12]
        expected = 2
        actual = self.sol.find_min_num_of_sticks_to_make_the_number_dp(Sticks, K)
        self.assertEqual(expected, actual)

    def test_case1_a(self):
        K = 14
        Sticks = [1, 5, 12]
        expected = 3
        actual = self.sol.find_min_num_of_sticks_to_make_the_number_dp(Sticks, K)
        self.assertEqual(expected, actual)

    def test_case2(self):
        K = 68
        Sticks = [1,14,30,17]
        expected = 4
        actual = self.sol.find_min_num_of_sticks_to_make_the_number_dp(Sticks, K)
        self.assertEqual(expected, actual)

    def test_case3(self):
        K = 109
        Sticks = [13,17,43,100,110,120]
        expected = -1
        actual = self.sol.find_min_num_of_sticks_to_make_the_number_dp(Sticks, K)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
