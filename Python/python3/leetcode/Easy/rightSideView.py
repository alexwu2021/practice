from typing import List, Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


from python3.leetcode.common_types import TreeNode


class Solution:

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def solve(n, lvl):
            if n:
                if len(res) == lvl:
                    res.append(n.val)
                solve(n.right, lvl + 1)
                solve(n.left, lvl + 1)
            return

        res = []
        solve(root, 0)
        return res