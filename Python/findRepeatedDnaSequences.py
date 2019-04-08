from collections import Counter

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        res = []
        if not s  or len(s) < 10:
            return res
        c = Counter(s[i:i+10] for i in range(len(s)-9))
        return [k for k in c.keys() if c[k] > 1]
        