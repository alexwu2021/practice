from typing import List
from collections import deque
class IslandParameter:


    def islandPerimeter(self, grid: List[List[int]]) -> int:
        perimeter = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    perimeter += 4


                    # for this new cell, if it has left, subtract one from the new cell count and one from the left side guy
                    if i > 0 and grid[i - 1][j] == 1:
                        perimeter -= 2

                    # similarly for up side comparison
                    if j > 0 and grid[i][j - 1] == 1:
                        perimeter -= 2
        return perimeter

grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
actual = IslandParameter().islandPerimeter(grid)
expected = 16
assert (expected == actual)