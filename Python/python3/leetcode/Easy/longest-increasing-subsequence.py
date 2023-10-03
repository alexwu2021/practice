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

