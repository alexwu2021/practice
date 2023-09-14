import os,sys,unittest

class Solution(unittest.TestCase):
    def minPathSum(self, mat):
        rowsize, colsize = len(mat), len(mat[0])
        dp =[0] * colsize
        dp[0] = mat[0][0]
        for r in range(1,colsize):
            dp[r] += dp[r-1] + mat[0][r]    #initial assignment

        for i in range(1, rowsize):         #for all rows first
            dp[0] +=  mat[i][0]             #drop-by-pillar
            for j in range(1,colsize):
                dp[j] = min(dp[j-1] , dp[j] ) + mat[i][j]

        return dp[colsize-1]


    def minPathSum_nanGuo(self, grid):
        m = len(grid); n = len(grid[0])
        dp = [[0 for i in range(n)] for j in range(m)]
        dp[0][0] = grid[0][0]
        for i in range(1, n):
            dp[0][i] = dp[0][i-1] + grid[0][i]
        for i in range(1, m):
            dp[i][0] = dp[i-1][0] + grid[i][0]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        return dp[m-1][n-1]

    def test_minPathSum(self):
        mat=[[1,3,7],[4,5,7],[8,1,0]]
        res = self.minPathSum(mat)
        res2 = self.minPathSum_nanGuo(mat)
        self.assertTrue(res == 10 and res == res2)

        mat=[[5,6,7],[4,9,8],[2,3,12]]
        res = self.minPathSum(mat)
        res2 = self.minPathSum_nanGuo(mat)
        self.assertTrue(res == 26 and res == res2)

        mat=[[5,6, 0, 7],[4,1, 9,8],[2, 7, 3,12], [4, 2, 13, 3]]
        res = self.minPathSum(mat)
        res2 = self.minPathSum_nanGuo(mat)
        self.assertTrue(res == 33 and res == res2)

        mat=[[5,6, 3, 0, 7],[4,1, 0, 9,8],[2, 7, 3,12, 7], [4, 2, 13, 3, 4], [4, 2, 13, 3, 4]]
        res = self.minPathSum(mat)
        res2 = self.minPathSum_nanGuo(mat)
        self.assertTrue(res == res2)

if __name__ == '__main__':
    unittest.main()
