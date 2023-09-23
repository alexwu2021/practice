from typing import List

# reclaim water to be part of island

# You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
# We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
# Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
# An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        if not positions or not m or not n: return []

        def find(idx):
            while roots[idx] != idx:
                roots[idx] = roots[roots[idx]]
                idx = roots[idx]
            return idx

        ans = []
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        roots = [-1] * m * n
        count = 0

        for x, y in positions:
            root = x * n + y
            if roots[root] != -1:
                ans.append(count)
                continue

            roots[root] = root
            count += 1
            for d in directions:
                nx, ny = x + d[0], y + d[1]
                nroot = nx * n + ny
                if not 0 <= nx < m or not 0 <= ny < n or roots[nroot] == -1: continue
                nroot = find(nroot)
                if nroot != root:
                    roots[root] = nroot
                    root = nroot
                    count -= 1
            ans.append(count)

        return ans
