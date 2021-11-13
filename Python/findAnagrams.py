 # from collections import Counter
 #
 #    #this one accepted, I copied this answer from the discussion area. still need think more about it.
 #    def findAnagrams(self, s, p):
 #        """
 #        :type s: str
 #        :type p: str
 #        :rtype: List[int]
 #        """
 #        res = []
 #        pCounter = Counter(p)
 #        sCounter = Counter(s[:len(p)-1])
 #        for i in range(len(p)-1,len(s)):
 #            sCounter[s[i]] += 1
 #            if sCounter == pCounter:
 #                res.append(i-len(p)+1)
 #            sCounter[s[i-len(p)+1]] -= 1
 #            if sCounter[s[i-len(p)+1]] == 0: #we have to maintain this, otherwise, the result will be wrong
 #                del sCounter[s[i-len(p)+1]]
 #        return res
