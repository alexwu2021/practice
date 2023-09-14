class Solution:
    
    def constructMaximumBinaryTree_borrowed(self, nums):
        if nums:
            pos = nums.index(max(nums))
            root = TreeNode(nums[pos])
            root.left = self.constructMaximumBinaryTree(nums[:pos])
            root.right = self.constructMaximumBinaryTree(nums[pos+1:])
            return root
    
    
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