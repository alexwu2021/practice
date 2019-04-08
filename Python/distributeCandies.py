import unittest
from collections import Counter

class Solution(unittest.TestCase):

    #essentially this is a greedy aglo.
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        size = len(candies)
        target = size // 2
        counter = Counter(candies)
        res = []
        
        i = 0
        remaining = []
        for c in counter:
            if counter[c] == 1:
                res.append(c)
                i += 1
            else:
                remaining.append((counter[c], c))
        #print('res: %s; counter: %s; remaining: %s' % (res, counter, remaining))
        for r in sorted(remaining):
            if i < target:
                res.append(r[1])
                i += 1
        return res

    def testx(self):
        candies = [1,1,3, 3, 4, 4]
        res = self.distributeCandies(candies)
        print('for candies %s, res: %s' % (candies, res))
        self.assertTrue(sorted(res) == [1, 3, 4])
        candies = [1,1,2,3]
        res = self.distributeCandies(candies)
        print('for candies %s, res: %s' % (candies, res))
        self.assertTrue(sorted(res) == [2, 3])

        candies = [1,1,1, 1, 2,3]
        res = self.distributeCandies(candies)
        print('for candies %s, res: %s' % (candies, res))
        self.assertTrue(sorted(res) == [1, 2, 3])

        candies = [9,9,1, 1, 2,3]
        res = self.distributeCandies(candies)
        print('for candies %s, res: %s' % (candies, res))
        self.assertTrue(sorted(res) == [1, 2, 3])
 

if __name__ == '__main__':
    unittest.main()
