# 528
import unittest
from typing import List
import random, bisect

# ou are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
#
# You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
#
# For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).

class PickByWeight:
    def __init__(self, w: List[int]):
        w = list(map(lambda x: x / sum(w), w))
        for x in range(1, len(w)):
            w[x] += w[x - 1]
        self.w = w


    def pickIndex(self) -> int:
        r = random.uniform(0, 1)
        return bisect.bisect_left(self.w, r)


class TestPickByWeight(unittest.TestCase):
    def test1(self):
        sol = PickByWeight([])
        actual = sol.pickIndex()
        expect = 0
        self.assertEqual(expect, actual)

    def test2(self):
        sol = PickByWeight([1, 3])
        actual = [sol.pickIndex(), sol.pickIndex(), sol.pickIndex(), sol.pickIndex(), sol.pickIndex()]
        expect = [1, 1, 1, 1, 0]
        self.assertEqual(expect, actual)


if __name__ == '__main__':
        unittest.main()

