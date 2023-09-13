import unittest
from functools import cache
from typing import List

# 1762. Buildings With an Ocean View
class BuildingsWithOceanView:
    def findBuildings(self, heights: List[int]) -> List[int]:
        res = [len(heights) - 1]
        for i in range(len(heights) - 2, -1, -1):
            if heights[i] > heights[res[-1]]:
                res.append(i)
        res.reverse()
        return res
    def findBuildings_recursive(self, heights: List[int]) -> List[int]:
        def dfs(heights, index: int, accu,):
            if index < 0:
                return
            if heights[index] > heights[accu[-1]]:
                accu.append(index)
            return dfs(heights, index - 1, accu)

        accu = [len(heights) - 1]
        dfs(heights, len(heights) - 2, accu)
        accu.reverse()
        return accu


class TestBuildingsWithOceanView(unittest.TestCase):
    sol = BuildingsWithOceanView()

    def test_case1(self):
        heights = [4, 1, 2, 3]
        expected = [0, 3]

        # actual = self.sol.findBuildings(heights)
        actual = self.sol.findBuildings_recursive(heights)
        self.assertEqual(expected, actual)

    def test_case2(self):
        heights = [4,2,3,1]
        expected = [0, 2, 3]

        actual = self.sol.findBuildings(heights)
        actual = self.sol.findBuildings_recursive(heights)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()
