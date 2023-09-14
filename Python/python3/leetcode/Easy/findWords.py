class Solution:
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        def isMadeUpof(word, row):
            lst = [x for x in row]
            for c in word:
                if c.lower() not in lst:
                    return False
            return True
        ret = []
        rows = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm']
        for word in words:
            for r in rows: 
                if isMadeUpof(word, r):
                    ret.append(word)
        return ret

s = Solution()
res = s.findWords(['Alaska', 'random'])
print(res)
