from typing import Optional
import unittest
from python3.leetcode.common_types import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BottomLeftVal:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        stack = []

        def dfs(n, p, level):
            if not n: return
            if not n.left and not n.right:
                if not p or n == p.left or not p.left:
                    while stack and level > stack[-1][0]:
                        print("level %d, stack[-1]%s" % (level, stack[-1]))
                        stack.pop()
                    stack.append((level, n.val))
                return

            dfs(n.left, n, level + 1)
            dfs(n.right, n, level + 1)

        dfs(root, None, 0)
        return stack[-1][1] if len(stack) == 1 else stack[0][1]


class TestBottomLeftVal(unittest.TestCase):
    sol = BottomLeftVal()

    def test_case1(self):
        root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)
        expected = 1
        actual = self.sol.findBottomLeftValue(root)
        self.assertEqual(expected, actual)

    def test_case2(self):
        root = TreeNode(0)

        root.right = TreeNode(-1)
        expected = -1
        actual = self.sol.findBottomLeftValue(root)
        self.assertEqual(expected, actual)

    def test_case3(self):
        root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(5)
        root.left.left = TreeNode(0)
        root.left.right = TreeNode(2)
        root.right.left = TreeNode(4)
        root.right.right = TreeNode(6)

        expected = 0
        actual = self.sol.findBottomLeftValue(root)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
