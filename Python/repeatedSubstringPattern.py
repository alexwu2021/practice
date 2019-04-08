import os, sys, unittest


class Solution(unittest.TestCase):
    def test_repeatedSubstringPattern(self):
        s = 'abab'
        res = self.repeatedSubstringPattern(s)
        self.assertTrue(res)

        s = 'a'
        res = self.repeatedSubstringPattern(s)
        self.assertFalse(res)

        s = "abaababaab"
        res = self.repeatedSubstringPattern(s)
        self.assertTrue(res)
        
    def hasTheSameCount(self, counter):
        lst = list(counter.keys())
        val = counter[lst[0]]
        if val == 0:
            return False
        for k in lst:
            if counter[k] <= 0 or counter[k] != val:
                return False
        return True
        
    def repeatedSubstringPattern(self, s):
        #not valid, need improvement
        """
        :type s: str
        :rtype: bool
        """
        if s is None: return False
        
        size = len(s)
        if size <= 0:
            return False
        
        counter = {}
        for ch in s:
            if ch in counter:
                counter[ch] += 1
            else:
                counter[ch] = 1
        
        if not self.hasTheSameCount(counter):
            return False
       
        temp = ''
        index, keyCount = 0, len(counter.keys())
        counter[s[index]] -= 1
        temp += s[index]
        while index < keyCount and not self.hasTheSameCount(counter):
            index += 1
            if index < size:
                counter[s[index]] -= 1
                temp += s[index]
            else:
                break
            
            
        i, j, tempLen = 0, 0, len(temp)
        while j < size:
            while i < tempLen and j < size:
                if temp[i] == s[j]:
                    i += 1
                    j += 1
                else:
                    return False
            i = 0
        
        if j != size:
            return False
        
        return True


if __name__ == '__main__':
    unittest.main()
