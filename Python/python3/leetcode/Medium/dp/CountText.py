import unittest

class CountText:
    def countTexts(self, S: str) -> int:

        mod = 10 ** 9 + 7

        dp = [0] * (len(S) + 1)
        dp[0] = 1
        for i in range(1, len(S) + 1):
            prev, prev2, prev3, prev4 = i - 1, i - 2, i - 3, i - 4

            dp[i] = dp[prev]
            if prev2 >= 0 and S[prev] == S[prev2]:
                dp[i] += dp[prev2]
            if prev3 >= 0 and S[prev] == S[prev2] and S[prev] == S[prev3]:
                dp[i] += dp[prev3]

            if S[prev] in {'7', '9'}:
                if prev4 >= 0 and S[prev] == S[prev2] and S[prev] == S[prev3] and S[prev] == S[prev4]:
                    dp[i] += dp[prev4]
            dp[i] %= mod

        return dp[-1] % mod

class TestCountText(unittest.TestCase):
    sol = CountText()

    def test_case1(self):
        pressedKeys = "22233"
        expected = 8
        actual = self.sol.countTexts(pressedKeys)
        self.assertEqual(expected, actual)

    def test_case2(self):
        pressedKeys = "222222222222222222222222222222222222"
        expected = 82876089
        actual = self.sol.countTexts(pressedKeys)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
