
import unittest
class Solution(unittest.TestCase):
    
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxCur, maxSoFar = 0, 0
        for i in range(1, len(prices)):
            maxCur += prices[i] - prices[i-1]
            maxCur = max(0, maxCur)
            maxSoFar = max(maxCur, maxSoFar)
        return maxSoFar
    
    def test_maxProfit(self):
        chars = [3,3,5,0,0,3,1,4]
        res = self.maxProfit(chars)
        print('for input: %s; res:%d' % (chars, res))
        self.assertTrue(res == 4)
        



if __name__ == '__main__':
    unittest.main()
