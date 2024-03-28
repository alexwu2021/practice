from typing import List
import unittest
import heapq, bisect

class ThePoints:

    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        m, n = len(grid), len(grid[0])
        heap = [(grid[0][0], 0, 0)]
        v = {(0, 0)}
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        orders = []

        while len(heap) > 0:
            curr, i, j = heapq.heappop(heap)
            orders.append(curr)
            for dir in dirs:
                x, y = i + dir[0], j + dir[1]
                if 0 <= x < m and 0 <= y < n and (x, y) not in v:
                    v.add((x, y))
                    heapq.heappush(heap, (grid[x][y], x, y))

        curr_max = orders[0]
        for i in range(1, len(orders)):
            orders[i] = max(orders[i], curr_max)
            curr_max = max(curr_max, orders[i])

        return [bisect.bisect_left(orders, q) for q in queries]
    #
    # def maxPoints_maxLoop(self, grid: List[List[int]], queries: List[int]) -> List[int]:
    #     ans = []
    #     m, n = len(grid), len(grid[0])
    #     dir = [(1, 0), (0, 1),  (-1, 0), (0, -1)]
    #
    #     def dfs(x, i, j, seen):
    #         nonlocal accu
    #
    #         if not seen[i][j]:
    #             seen[i][j] = True
    #             if x > grid[i][j]:
    #                 accu += 1
    #         if x <= grid[i][j]:
    #             return
    #         for d in dir:
    #             nx, ny = i + d[0], j + d[1]
    #             if 0 <= nx < m and 0 <= ny < n:
    #                 dfs(x, nx, ny, seen)
    #
    #     for x in queries:
    #         accu = 0
    #         dfs(x, 0, 0, [[False] * n for _ in range(m)])
    #         ans.append(accu)
    #     return ans


class TestThePoints(unittest.TestCase):
    sol = ThePoints()

    def test_case1(self):
        grid = [[1,2,3],[2,5,7],[3,5,1]]
        queries = [5,6,2]
        expected = [5, 8, 1]
        actual = self.sol.maxPoints(grid, queries)
        self.assertListEqual(expected, actual)

    def test_case2(self):
        grid = [[5, 2, 1], [1, 1, 2]]
        queries = [3]


        expected = [0]
        actual = self.sol.maxPoints(grid, queries)
        self.assertListEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()