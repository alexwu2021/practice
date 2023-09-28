# 2313. Minimum Flips in Binary Tree to Get Result
# You are given the root of a binary tree with the following properties:
#
# Leaf nodes have either the value 0 or 1, representing false and true respectively.
# Non-leaf nodes have either the value 2, 3, 4, or 5, representing the boolean operations OR, AND, XOR, and NOT, respectively.
# You are also given a boolean result, which is the desired result of the evaluation of the root node.
#
# The evaluation of a node is as follows:
#
# If the node is a leaf node, the evaluation is the value of the node, i.e. true or false.
# Otherwise, evaluate the node's children and apply the boolean operation of its value with the children's evaluations.
# In one operation, you can flip a leaf node, which causes a false node to become true, and a true node to become false.
#
# Return the minimum number of operations that need to be performed such that the evaluation of root yields result. It can be shown that there is always a way to achieve result.
#
# A leaf node is a node that has zero children.
#
# Note: NOT nodes have either a left child or a right child, but other non-leaf nodes have both a left child and a right child.

from typing import Optional

from python3.leetcode.common_types import TreeNode

class MinimumFlips:

    def minimumFlips(self, root: Optional[TreeNode], result: bool) -> int:
        def dfs(node):
            if node.val == 0:
                return 1, 0
            if node.val == 1:
                return 0, 1

            if node.val == 5:  # NOT
                child = node.left if node.left else node.right
                t, f = dfs(child)
                return f, t

            lt, lf = dfs(node.left)
            rt, rf = dfs(node.right)

            if node.val == 2:  # OR
                return min(lt + rt, lf + rt, lt + rf), lf + rf

            if node.val == 3:  # AND
                return lt + rt, min(lt + rf, lf + rt, lf + rf)

            if node.val == 4:  # XOR
                return min(lf + rt, lt + rf), min(lt + rt, lf + rf)

        t, f = dfs(root)
        return t if result else f