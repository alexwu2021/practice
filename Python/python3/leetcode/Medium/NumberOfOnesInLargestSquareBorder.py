from itertools import accumulate, product
from typing import List


# Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border,
# or 0 if such a subgrid doesn't exist in the grid.
class NumberOfOnesInLargestSquareBorder:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        lpref = [[0] * n for _ in range(m)]  # left prefix
        vpref = [[0] * n for _ in range(m)]  # up prefix
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    lpref[i][j] = 1 + lpref[i][j - 1]
                    vpref[i][j] = 1 + vpref[i - 1][j]
        output = 0

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if grid[i][j]:
                    size = min(lpref[i][j], vpref[i][j])
                    while size > output:
                        if lpref[i - size + 1][j] >= size and vpref[i][j - size + 1] >= size:
                            output = size
                        size -= 1

        return output ** 2

    def largest1BorderedSquare_slow(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        R, C = [list(accumulate(x)) for x in grid], [accumulate(x) for x in zip(*grid)]
        C = [list(x) for x in zip(*C)]

        for k in range(min(m, n), 0, -1):
            for i, j in product(range(m-k+1), range(n-k+1)):
                if min(R[i][j+k-1] - R[i][j], C[i+k-1][j] - C[i][j], R[i+k-1][j+k-1] - R[i+k-1][j],\
                       C[i+k-1][j+k-1] - C[i][j+k-1]) >= k-1 and grid[i][j]:
                    return k * k
        return 0
