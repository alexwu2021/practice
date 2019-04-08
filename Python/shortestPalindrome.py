import sys, os, timeit
from collections import Counter

class Solution:
    def isPalin(self, s):
        size = len(s)
        mid = size // 2
        i = 0
        while i < mid:
            if s[i] != s[size -i -1]:
                return False
            i += 1
        return True
    def getMinExtenseSteps(self, s, i):
        """
        :rtype: a pair of steps to extend, and cut off point index
        """
        cutoff = i
        size = len(s)
        j,k = i, i
        while j >= 0 and k < size and s[j] == s[k]:
            j -= 1
            k += 1
        if j > 0 or (j == 0 and s[j] != s[k]):
            return (-sys.maxsize, -sys.maxsize)
        return (size-1 - k + 1, i)
            
    def genFullString(self, s, cutoff, steps):
        print('entering genFullString with index %s as cutoff' % cutoff)
        lst = []
        size = len(s)
        for i in range(size-1, size-steps-1, -1):
            lst.append(s[i])
        print('lst: %s' % lst)
        return ''.join(lst) + s
        
        
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        counter = Counter()
        for ch in s:
            counter[ch] += 1
            
        if sum(1 for c in counter if counter[c] > 1) < 1:
            remain = str(s[1:])
            return remain[::-1] + s

        size = len(s)
        i = 1
        largestPalindromSize = -sys.maxsize
        while i < size:
            if self.isPalin(s[0:i+1]):
                largestPalindromSize = max(largestPalindromSize, i+ 1)
            i += 1
        if largestPalindromSize != -sys.maxsize:
            rem = str(s[largestPalindromSize:])
            print('due to leftmost palin, to return %s' % (rem[::-1] + s))
            return rem[::-1] + s
        
        minSteps = sys.maxsize
        minString = ''
        for i in range(size -1, -1, -1):
            
            steps, cutoff = self.getMinExtenseSteps(s, i)
            print('getMinExtenseSteps i: %s; cutoff: %s; steps: %s' % (i, cutoff, steps))
            if steps != -sys.maxsize and steps < minSteps:
                minSteps = steps
                minString = self.genFullString(s, cutoff, steps)
        return minString
            

sol = Solution()
s ='abbacd'
res = sol.shortestPalindrome(s)
print('s: %s, res: %s' % (s, res))
            
