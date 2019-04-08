class Solution:
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        capitals = [chr(65 + x) for x in range(26)]
        res = ''
        while n:
            n, rem = divmod(n-1, 26)
            res = capitals[rem] + res
        return ''.join(res)