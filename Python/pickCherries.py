
import os,sys,unittest

class Solution(unittest.TestCase):
    #invalid, need more work
    _mat = None
    _rowsize, _colsize = 0, 0
    def pickCherries(self, mat):
        self._mat = mat
        self._rowsize, self._colsize = len(mat), len(mat[0])

        if mat[0][0] <0 or mat[self._rowsize-1][self._colsize-1] <0:
            print ('bad config, noop')
            return 0

        
        visited = [[2] *self._colsize ] * self._rowsize
        
        deque = [[(0, 0)]]
        changed = False
        while len(deque) > 0 and changed:
            front = deque.pop(0)
            temp = []
            for f in front:
                if f[1] + 1 < self._colsize and self._mat[f[0], f[1]] >= 0:
                    temp.append((f[0], f[1] + 1))
                    changed = True
                if f[0] + 1 < self._rowsize and self._mat[f[0], front[1]] >= 0:
                    temp.append((f[0] + 1, f[1]))
            deque.update(temp)
        
        
        pathes = []
        while self.hasUnvisited(visited):
            path = self.generateAPath(visited, deque)
            pathes.append(path)

        res = 0 - sys.maxsize
        for p in pathes:
            (pval, rem) = getPathValueAndRemainingMatrix(p)
            res = max(res, pval + maxPathSum(rem))
        return res


    def generateAPath(self, visited, layered):
        res = []
        for lyr in layered:
            if len(lyr) == 1:
                res.append(lyr[0])
                visited[lyr[0][0]][lyr[0][1]] -=  1
            else:
                index = random.randomint(0, len(lyr))
                res.append(lyr[index])
                visited[lyr[index][0]][lyr[index][1]] -=  1
        return res
            

    def hasUnvisited(self, visited):
        for i in range(self._rowsize):
            for j in range(self._colsize):
                if visited[i][j] < 2:
                    return True
        return False
        
    def getPathValueAndRemainingMatrix(self, p):
        pval = 0
        mt = copy(self._mat)
        return (pval, mt)
    
    
    def maxPathSum(self, mat):
        dp = [0] * colsize
        dp[self._colsize -1] = self._mat[self._rowsize-1][self._colsize-1]
        for i in range (self._colsize -2, -1 -1):
            dp[i] += (dp[i+1] + self._mat[self._rowsize-1][i]) if self._mat[self._rowsize-1][i] >= 0 else 0
        for i in range(self._colsize-2, -1, -1):
            dp[i] += self._mat[self._colsize -2][i]
            for j in range(self._colsize -2, -1 , -1):
                dp[j] = max(dp[j], dp[j+1]) + self._mat[i][j] if self._mat[i][j] >= 0 else 0
        return dp[0]

    
    def test_pickCherries(self):
        mat=[[0,1,-1],[1,0,-1],[1,1,1]]
        res = self.pickCherries(mat)
        print('res: %s' % res)
        #res2 = self.pickCherries2(mat)
        self.assertTrue(res == 5) # and res == res2)

       

if __name__ == '__main__':
    unittest.main()
