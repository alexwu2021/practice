from python3.leetcode.common_types import TreeNode


class Solution:


    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums or len(nums) <= 0:
            return None
   
        mxi = nums.index(max(nums))
        r = TreeNode(nums[mxi])
        r.left = self.constructMaximumBinaryTree(nums[0:mxi])
        r.right = self.constructMaximumBinaryTree(nums[mxi+1:])
        
        return r