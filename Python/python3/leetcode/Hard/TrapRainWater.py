import unittest
from typing import List

class TrapRainWater:

    def trap(self, height: List[int]) -> int:
        ans = 0
        i = 0
        stk = []
        while i < len(height):
            while len(stk) > 0 and height[i] > height[stk[-1]]:
                oldStackHi = height[stk[-1]]
                stk.pop()

                if len(stk) == 0: break

                dist = i - stk[-1] - 1
                newHigherHi = min(height[stk[-1]], height[i])
                ans += dist * (newHigherHi - oldStackHi)

            stk.append(i)
            i += 1

        return ans

class TestTrapRainWater(unittest.TestCase):
    sol = TrapRainWater()

    def test_case1(self):
        height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        expected = 6
        actual = self.sol.trap(height)
        self.assertEqual(expected, actual)

    def test_case2(self):
        height = [4,2,0,3,2,5]
        expected = 9
        actual = self.sol.trap(height)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
