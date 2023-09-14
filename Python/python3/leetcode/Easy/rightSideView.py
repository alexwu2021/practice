# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def rightSideView_mine(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def dfs(node, path):
            if not node:
                return
            path.append(node.val)
            dfs(node.right, path)
        
        ret = []
        dfs(root, ret)
        return ret
    
    #stenfanP's solution.
    #the trick part is that the left tree might have some aspects exposed to the right view, so has to be covered under the height
    def rightSideView(self, root):
        def collect(node, depth):
            if node:
                if depth == len(view):
                    view.append(node.val)
                collect(node.right, depth+1)
                collect(node.left, depth+1)
        view = []
        collect(root, 0)
        return view
    