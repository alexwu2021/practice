import sys, unittest, timeit
#import stopwatch  #can't install it due to no matching version

class Solution(unittest.TestCase):
    #passed my own uni test, not tested in lc yet

    #for wujian's way
    low = sys.maxsize
    maxlen = -sys.maxsize

    def isPalin(self, s):
        size = len(s)
        mid = size // 2
        i = 0
        while i < mid:
            if s[i] != s[size -i -1]:
                return False
            i += 1
        return True


    #there is a time issue with this one,
    #may be still valid, needs some tuning up
    def getLongestSubPalindrom_mine_bad(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        mx = -sys.maxsize
        mxstring = ''
        size = len(s)
        dp = [-sys.maxsize] * (size + 1)
        dp[size] = 1
        for i in range(size-1, -1, -1):
            if i == size -1:
                dp[i] = dp[i + 1]
                mxstring = s[i]
            for j in range(i+ 1, size, 1):
                print ('eval: %s' % s[i:j + 1])
                if self.isPalin(s[i:j + 1]):
                    plen = j - i
                    if plen > mx:
                        mx = plen
                        mxstring = s[i:j + 1]
                    dp[j] = max(dp[j], dp[j+1] + 1)
                else:
                    dp[j] = max(dp[j], dp[j+1])
        print('dp[i]: %s'  % dp[i])
        return mxstring


     #for wujian's way
    def extendPalindrom(self, s, j, k):
        size = len(s)
        while j >= 0 and k < size and s[j] == s[k]:
            j -= 1
            k += 1
        if self.maxlen < k - j - 1:
            self.low = j + 1 #why this?
            self.maxlen = k-j -1

    #this one accepted
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) <= 1:
            return s
        for i in range(len(s)):
            self.extendPalindrom(s, i, i)
            self.extendPalindrom(s, i, i+ 1)
        return s[self.low:self.low + self.maxlen]
        
    
    
    

    def test_isPalin(self):
        #s = 'ababa'
        s = 'tattarrattat'
        res = self.isPalin(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(res)
     
    def test_getLongestSubPalindrom(self):
        s = 'accd'
        res = self.getLongestSubPalindrom(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(res == 'cc')

        s = 'tattarrattaty'
        res = self.getLongestSubPalindrom(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == len(s) -1)

        s = 'atattarrattatt'
        res = self.getLongestSubPalindrom(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == len(s) -2)
         

    
if __name__ == '__main__':
    #sol = Solution()
    #timeitResult = timeit.timeit(sol.test_getLongestSubPalindrom)
    #print('timeitResult: %s' % timeitResult)

    unittest.main()
    
