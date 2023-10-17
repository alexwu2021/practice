from typing import List

class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        self.m = []

        for row in matrix:
            temp = []
            for v in row:
                temp.append(v)
            self.m.append(temp)

        self.p = [[0] * (len(self.m[0]) + 1) for _ in range(len(self.m) + 1)]

        for i in range(1, len(self.p)):
            for j in range(1, len(self.p[0])):
                self.p[i][j] = self.p[i-1][j] + self.m[i-1][j-1]



    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
            self.p[row2 + 1][col2 + 1] + self.p[row1 + 1][col2 + 1] + self.p[row2+1][col1+1] - 2 * self.p[row1 + 1][col1+1];

