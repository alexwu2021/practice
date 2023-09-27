# 563. Binary Tree Tilt
# Given the root of a binary tree, return the sum of every tree node's tilt.
#
# The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.

from typing import Optional

from python3.leetcode.common_types import TreeNode


class BinTreeTilt:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        tilt = 0

        def val_sum(n):
            nonlocal tilt
            if not n: return 0
            l, r = val_sum(n.left), val_sum(n.right)
            tilt += abs(l - r)
            return l + r + n.val

        val_sum(root)
        return tilt