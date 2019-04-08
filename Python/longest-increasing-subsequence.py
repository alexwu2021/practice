import unittest
import os


class Solution(object):
	def lenOfLIS(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		dp[x] = max(dp[x], dp[y] + 1) for x > y and nums[x] > nums[y]
		7 lines of code
		"""
		size = len(nums)
		dp = [1] * size
		for x in range(1, size):
			for y in range(x):
				if nums[x] > nums[y]:
					dp[x] = max(dp[x], dp[y] + 1)
		#print (dp)
		return max(dp) if dp else 0

	def LIS(self, nums):
	   
		 """
		:type nums: List[int]
		:rtype: int
		dp[x] = max(dp[x], dp[y] + 1) for x > y and nums[x] > nums[y]
		7 lines of code
		"""
		size = len(nums)
		dp = [1] * size
		s = Set()
		for x in range(1, size):
			for y in range(x):
				if nums[x] > nums[y]:
					if dp[y] + 1 > dp[x]:
						s.add(nums[y])
					dp[x] = max(dp[x], dp[y] + 1)
					
		print (s)
		return s


nums = [1,4, 2, 3]
#nums = [10, 9, 2, 5, 3, 7, 101, 18]
#nums = []
sol = Solution()
res = sol.LIS(nums)
print('res: %s' % (res))
