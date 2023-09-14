# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
 
class Solution:
    def dfs(self, node):
        if not node :
            return -1
        leftCount = self.dfs(node.left)
        rightCount = self.dfs(node.right)
        self.d = max(leftCount + rightCount +  2, self.d)
        return max(leftCount, rightCount) + 1
    
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        self.d = 0
        self.dfs(root)
        return self.d
                     
    