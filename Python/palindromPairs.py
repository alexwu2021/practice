import os, sys, unittest, math

class Solution(unittest.TestCase):
    def palindromPairs(self, lst):
        #return [] if not found
        if lst is None or len(lst) <= 1:
            return []
        ret = []
        size = len(lst)
        for i in range(size -1):
            for j in range(i, size):
                if self.isPalindrom(lst[i], lst[j]):
                    ret.append([i,j])
        return ret


    def isPalindromHelper(self, s):
        n = len(s)
        mid = n>>1
        for i in range(mid + 1):
            if s[i] != s[n-i]:
                return False
        return True

    def isPalindrom(self, a, b):
        if abs(len(a)- len(b)) != 1:
            return False
        return self.isPalindromHelper(a + b) and self.isPalindromHelper(b + a)
    
    def test_palindromPairs(self):
        lst = ["bat", "tab", "cat"]
        ret = self.palindromPairs(lst)
        print('ret is %s' % ret)
        self.assertTrue(lst == [[0, 1], [1, 0]])

        lst = ["abcd", "dcba", "lls", "s", "sssll"]
        ret = self.palindromPairs(lst)
        print('ret is %s' % ret)
        self.assertTrue(lst == [[[0, 1], [1, 0], [3, 2], [2, 4]]])
 


if __name__ == '__main__':
    unittest.main()
