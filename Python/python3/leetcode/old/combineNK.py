from itertools import combinations
from functools import reduce

class Solution:
    #this one is even accepted
    def combine_builtin(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        return list(combinations(range(1, n+1), k))
    
    def combine(self, n, k):
        return reduce (lambda C, _: [[i] + c for c in C for i in range(1, c[0] if c else n+1)], range(k), [[]])
