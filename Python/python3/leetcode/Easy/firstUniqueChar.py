from collections import Counter

class Solution:
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s is None: return -1
        ln = len(s)
        if ln <= 0: return -1
        i = 0
        counter = Counter()
        while i < ln:
            counter[s[i]] += 1
            i += 1
            
        i = 0
        while i < ln:
            if counter[s[i]] == 1:
                return i
            i += 1
            
        return -1
    
