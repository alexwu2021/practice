from python3.leetcode.common_types import TreeNode


def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None
        
        n = len(nums)
        if n == 1:
            return TreeNode(nums[0])
            
        mid = n // 2
        root = TreeNode(nums[mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        
        if mid >=1:
            root.left = self.sortedArrayToBST(nums[0:mid])
        return root
        