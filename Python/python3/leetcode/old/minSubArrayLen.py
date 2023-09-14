import sys

class Solution:
    def minSubArrayLen_incorrect(self, nums, s):
        mx = 9999
        size = len(nums)
        start = 0
        sm = 0
        for i in range(size):
            sm += nums[i]
            while sm >= s:
                mx = min(mx, i - start + 1)
                sm -= nums[start]
                start += 1
                
        if (mx == 9999): return 0
        return mx

    def minSubArrayLen(self, nums, s):
        size = len(nums)
        dp = [[0] * size]* size
        print (dp)

        for i in range(size): dp[i][i] = 1
                
        print (dp)


sol = Solution()
nums = [3, 1, 1, 2, 2 ,4]
s = 7
res = sol.minSubArrayLen(nums, s)
print ('res: %s' % (res))
