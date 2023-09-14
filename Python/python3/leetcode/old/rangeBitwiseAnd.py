class Solution:
    #In one word, this problem is asking us to find the CommonTypes prefix of m and n 's binary code.
    #201. Bitwise AND of Numbers Range
    def (self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        while n > m:
            n &= (n-1);
        return n;