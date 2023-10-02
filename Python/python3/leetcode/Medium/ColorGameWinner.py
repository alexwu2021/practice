# 2038. Remove Colored Pieces if Both Neighbors are the Same Color
import unittest
import collections

class ColorGameWinner:


    # one char at a time is an impasse

    def winnerOfGame(self, s: str) -> bool:
        a = b = 0
        for i in range(1, len(s) - 1):
            if s[i - 1] == s[i] == s[i + 1]:
                if s[i] == 'A':
                    a += 1
                else:
                    b += 1
        return a > b




class TestColorGameWinner(unittest.TestCase):
    sol = ColorGameWinner()

    def test_case1(self):
        colors = "AAABABB"
        expected = True
        actual = self.sol.winnerOfGame(colors)
        self.assertEqual(expected, actual)

    def test_case2(self):
        colors = "AA"
        expected = False
        actual = self.sol.winnerOfGame(colors)
        self.assertEqual(expected, actual)

    def test_case3(self):
        colors = "ABBBBBBBAAA"
        expected = False
        actual = self.sol.winnerOfGame(colors)
        self.assertEqual(expected, actual)

    def test_case4(self):
        colors = "AAAAABBB"
        expected = True
        actual = self.sol.winnerOfGame(colors)
        self.assertEqual(expected, actual)

    def test_case5(self):
        colors = "BBBAAAABB"
        expected = True
        actual = self.sol.winnerOfGame(colors)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
