class Solution:


    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            ans[i] = ans[i & (i-1)] + 1
        return ans
