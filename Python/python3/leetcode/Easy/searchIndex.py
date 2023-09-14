class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums or target < nums[0]:
            return 0
        if target > nums[len(nums) -1]:
            return len(nums)
        
        
        return len([x for x in nums if x < target])