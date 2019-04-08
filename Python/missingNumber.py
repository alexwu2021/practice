class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        mid = (n + 1)//2 
        expectedSum = n * mid
        if (n  + 1) % 2 == 1:
            expectedSum += mid
        return expectedSum - sum(nums)
    