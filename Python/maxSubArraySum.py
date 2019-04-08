class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # d[j] = max(d[j-1], nums[j], d[j-1] + nums[j])
        
        i = 0
        mx = nums[i]
        sumSoFar = nums[i]
        
        i += 1
        while i < len(nums):
            sumSoFar += nums[i]
                
            if sumSoFar < nums[i]:
                sumSoFar = nums[i]
                
            mx = max(sumSoFar, mx, nums[i])
            i += 1
        return mx
            
