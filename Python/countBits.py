class Solution:


    #this one considered best, but hard to explain
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            ans[i] = ans[i & (i-1)] + 1
        return ans


    # P(x) = P(x/2) + (x mod 2)
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            #ans[i] = ans[i >> 1] + i % 2
            ans[i] = ans[i >> 1] + (i & 1)
        return ans
