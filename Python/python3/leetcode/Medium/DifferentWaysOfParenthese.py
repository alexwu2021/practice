# 241. Different Ways to Add Parentheses
from functools import lru_cache
from typing import List
import unittest

# Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
class DifferentWaysOfParenthese:
    @lru_cache(None)
    def diffWaysToCompute(self, s: str) -> List[int]:
        def get_val(m, n, op):
            if op == '+':
                return m + n
            elif op == '-':
                return m - n
            return m * n

        if s.isdigit():
            return [int(s)]  # base case

        res = []
        for i, c in enumerate(s):
            if c in "+-*":
                left = self.diffWaysToCompute(s[:i])
                right = self.diffWaysToCompute(s[i + 1:])
                res.extend([get_val(l, r, c) for l in left for r in right])
        return res


assert(DifferentWaysOfParenthese().diffWaysToCompute("2-1-1") == [2, 0])

assert(DifferentWaysOfParenthese().diffWaysToCompute("2*3-4*5") == [-34,-10,-14,-10,10])



