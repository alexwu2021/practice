import unittest


class Solution(unittest.TestCase):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] *(n + 1)
        dp[0] = 1
        for i in range(1, n+ 1):
            for j in range(i):
                print('before calc i: %d; j: %d; dp[i]: %d; dp[j]: %d' % (i, j, dp[i], dp[j]))
                dp[i] += dp[j] * dp[i-1-j]
                print('after calc i: %d; j: %d; dp[i]: %d; dp[j]: %d' % (i, j, dp[i], dp[j]))
        return dp[n]
    
    
        #catlan_numbers
        #f(n) = (2n) ! / (n + 1)!  * (n!)
    def test_numTree(self):
        n = 3
        res = self.numTrees(n)
        print('n: %d, res: %s' % (n, res))
        self.assertTrue(res == 5)



if __name__ == '__main__':
    unittest.main()
