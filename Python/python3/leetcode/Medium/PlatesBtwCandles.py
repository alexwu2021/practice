

# 2055. Plates Between Candles
# Medium
# There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.
#
# You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.
#
# For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
# Return an integer array answer where answer[i] is the answer to the ith query.
import unittest

from typing import List
from bisect import bisect


class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        plates = [i for i in range(len(s)) if s[i] == '|']  # indices for plates
        res = []
        for first, second in queries:
            l = bisect.bisect_left(plates, first)
            r = bisect.bisect_right(plates, second)
            res.append(plates[r - 1] - plates[l] - (r - 1 - l) if r > l else 0)
        return res
