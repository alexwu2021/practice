
import os, sys, unittest

class Solution(unittest.TestCase):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1: return "1"
        
        count = 0
        s = "1"
        ret = ''
        while count < n -1:
            s = self.tt(s, ret)
            count += 1
        return s
            
        
    def tt(self, s, ret):
        if s is None or len(s) <= 0:
            return ret
        
        i = 0
        ch = s[i]
        ch_count = 1
        i += 1
        while i < len(s) and  s[i] == ch:
            ch_count += 1
        ret += str(ch_count) + ch
        return self.tt(s[:(ch_count-1)], ret)

    def test_countAndSay(self):
        print('in test case')
        n = 1
        res = self.countAndSay(n)
        self.assertTrue(res == '1')

        n = 2
        res = self.countAndSay(n)
        self.assertTrue(res == '11')

        n = 3
        res = self.countAndSay(n)
        self.assertTrue(res == '21')

        n = 4
        res = self.countAndSay(n)
        self.assertTrue(res == '1211')

        n = 5
        res = self.countAndSay(n)
        self.assertTrue(res == '111221')
        print ('all done')





if __name__ == '__main__':
    unittest.main()
