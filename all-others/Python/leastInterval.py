import unittest
from collections import Counter
class Solution(unittest.TestCase):
    #accepted, and I love this one more,
    #the general idea is greedy, and make frame based on the most frequent tasks
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        m = len(tasks)
        c = sorted(Counter(tasks).values(), reverse = True)
        c = [x - 1 if x == max(c) else x for x in c]
        return max(c[0] * (n + 1) + m - sum(c), m)
    
    #accepted, directly translated from other's implementation
    def leastInterval_translated(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        c = [0] * 26;
        for t in tasks:
            c[ord(t) - ord('A')] += 1
        c = sorted(c)
        i = 25
        while i >= 0 and c[i] == c[25]:
            i -= 1
        return max(len(tasks), (c[25] - 1) * (n + 1) + 25 - i)


    def test_leastInterval(self):
        n = 2
        tasks = 'ACCCEEE'
        res = self.leastInterval(tasks, n)
        self.assertTrue(res == 8)


if __name__ == '__main__':
    unittest.main()




        #n = 3
        #tasks = 'AAAABBBEEFFGG'
        #res = self.leastInterval(tasks, n)
        #self.assertTrue(res == len(tasks))
        
        #n = 2
        #tasks = 'AACCCBEEE'
        #res = self.leastInterval(tasks, n)
        #self.assertTrue(res == len(tasks))
        
        #n = 3
        #tasks = 'AACCDDEEE'
        #res = self.leastInterval(tasks, n)
        #self.assertTrue(res == len(tasks))
