from typing import Optional
import unittest

from python3.leetcode.common_types import TreeNode


class PathSum:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans = 0
        def dfs(n, curr):
            nonlocal ans
            if not n:
                return
            temp = curr * 10 + n.val
            if (not n.left) and (not n.right):
                ans += temp
                return
            dfs(n.left, temp)
            dfs(n.right, temp)
        dfs(root, 0)
        return ans

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
assert(PathSum().sumNumbers(root) == 25)
