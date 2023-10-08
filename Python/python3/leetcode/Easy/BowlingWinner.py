#   2660.

from typing import List
import unittest

class BowlingWinner:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        def calc(a):
            sm = 0
            i = 0
            hit = 0
            mult = 0
            while i < len(a):
                mult = 0
                hit -= 1
                if hit < 0:
                    hit = 0
                elif hit > 0:
                    mult = 1
                sm += a[i] * (1 + mult)
                if a[i] == 10:
                    hit = 3
                i += 1
            return sm

        p1score = calc(player1)
        p2score = calc(player2)
        if p1score > p2score:
            return 1
        elif p1score == p2score:
            return 0
        return 2




class TestBowlingWinner(unittest.TestCase):
    sol = BowlingWinner()

    def test_case1(self):
        player1 = [10, 2, 2, 3]
        player2 =[3, 8, 4, 5]
        actual = self.sol.isWinner(player1, player2)
        expected = 1
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()




















