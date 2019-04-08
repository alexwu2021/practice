class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        d = [0] * n 
       
        for i in range(n):
            d[i] = height[i]
        
        for i in range(1, n):
            avg = d[i-1] / (i * 1.0)
            if height[i] >= avg:
                d[i] = max(d[i], d[i-1], d[i-1] + avg)
            else:
                d[i] = max(d[i], d[i-1], height[i] * (1 + d[i-1]/(avg *1.0)))

        for j in range(n):
            print('d[%d]:%d' % (j, d[j]))
        
        return d[n-1]


sol =   Solution()
height = [10, 8, 0, 7, 7, 9, 9]
ret = sol.maxArea(height)
print('ret: %d' % ret)
