class Solution:
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for i in range(len(nums)):
            if nums[abs(nums[i]) -1] >  0:
                nums[abs(nums[i]) -1] = - nums[abs(nums[i]) -1] 
            else:
                res.append(abs(nums[i]))
        return res
