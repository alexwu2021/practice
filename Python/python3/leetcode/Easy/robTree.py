# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

##f1(node) be the value of maximum money we can rob from the subtree with node as root ( we can rob node if necessary).

##f2(node) be the value of maximum money we can rob from the subtree with node as root but without robbing node.

##Then we have

##f2(node) = f1(node.left) + f1(node.right) and

##f1(node) = max( f2(node.left)+f2(node.right)+node.value, f2(node) ).


class Solution:
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def robDFS(node):
            if node is None:
                return (0, 0)
            ll= robDFS(node.left)
            rr = robDFS(node.right)
            return (ll[1] + rr[1], max(ll[1] + rr[1], ll[0] + rr[0] + node.val))
        return robDFS(root)[1];
    