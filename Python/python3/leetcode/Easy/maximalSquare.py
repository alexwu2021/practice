class MaximalSquare(object):
    #accepted, beat 54%
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        if n <= 0 or m <= 0:
            return 0
        dp = [[0 for i in range(n)] for _ in range(m)]
        maxsize = 0
        for j in range(n):
            dp[0][j] = ord(matrix[0][j]) - ord('0') #pay attention to the input format, it is '0' not 0
            maxsize = max(maxsize, dp[0][j])  #easy to forget this part
            
        for i in range (m):
            dp[i][0] = ord(matrix[i][0]) - ord('0')
            maxsize = max(maxsize, dp[i][0])  #easy to forget this part
            
        for i in range (1, m):
            for j in range(1, n):
                if matrix[i][j] == '1': #careful, it is '1' not 1
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    maxsize = max(maxsize, dp[i][j])
                
        return maxsize * maxsize
    
    