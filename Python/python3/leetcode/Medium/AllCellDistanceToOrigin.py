from typing import List

# 1030
# You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
# Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance.
# You may return the answer in any order that satisfies this condition.
# The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
class AllCellDistanceToOrigin:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        def dfs(i, j):
            seen.add((i, j))
            res.append([i, j])
            for x, y in (i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1): # 1
                if 0 <= x < R and 0 <= y < C and (x, y) not in seen:
                    dfs(x, y)

        res, seen = [], set()
        dfs(r0, c0)
        return sorted(res, key=lambda x: abs(x[0] - r0) + abs(x[1] - c0)) # 2