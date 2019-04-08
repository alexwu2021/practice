def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        
        while n > 1:
            if n % 2 == 0:
                n = n /2
            else:
                return False
        return n == 1