class Solution:
    def numWays(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if n == 0:
            return 0
        if n == 1:
            return k
      
    
        same, diff = k, k*(k-1)  # “no more than two adjacent fence posts have the same color.”
        for i in range(3, n + 1):
            same, diff = diff, (same + diff) * (k-1) #in retrospect, last round's diff is this time's same
        return same + diff