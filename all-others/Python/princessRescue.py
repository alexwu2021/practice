
import os, sys, unittest

class Solution(unittest.TestCase):
    def princessRescue(self, mat): #this is wrong implementation, for it cannot account for the positive value
        ### mat is a matrix, m by n
        rowsize = len(mat)
        colsize = len(mat[0])
        dp = [sys.maxsize] * (colsize + 1)
        dp[-1] = 0
        for r in range(rowsize-1, -1, -1):
            for c in range(colsize-1, -1 , -1):
                if mat[r][c] < 0:
                    dp[c] = min(dp[c], dp[c + 1] + 1 - mat[r][c])
                else:
                    dp[c] = min(dp[c], dp[c + 1] + mat[r][c])

        return dp[0]
        
    def test_princessRescue_goodcase(self):
        print('test_princessRescue_goodcase')
        mat = [[3, 1, -9], [2, -5, -6], [-4, -2 ,-2]]
        res = self.princessRescue( mat)
        unittest.assertTrue(res == 4)
                            

if __name__ == '__main__':
    unittest.main()
