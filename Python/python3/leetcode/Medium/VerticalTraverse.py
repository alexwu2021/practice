import unittest
from typing import List, Optional
from collections import deque, defaultdict

# 314. Binary Tree Vertical Order Traversal
# Given the root of a binary tree, return the vertical order traversal of its nodes' values.
# (i.e., from top to bottom, column by column).
#
# If two nodes are in the same row and column, the order should be from left to right.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class VerticalTraverse:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        columns = defaultdict(list)

        q = deque([(root, 0)])
        while q:
            node, x = q.popleft()
            columns[x].append(node.val)

            if node.left:
                q.append((node.left, x - 1))
            if node.right:
                q.append((node.right, x + 1))

        return [columns[x] for x in range(min(columns), max(columns) + 1)]

    def verticalOrder2(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        columns = defaultdict(list)

        q = deque([(root, 0)])
        while len(q) > 0: # not much into this way while q:
            node, x = q.popleft()
            columns[x].append(node.val)

            if node.left:
                q.append((node.left, x - 1))
            if node.right:
                q.append((node.right, x + 1))

        return [columns[x] for x in range(min(columns), max(columns) + 1)]


class TestVerticalTraverse(unittest.TestCase):
    sol = VerticalTraverse()

    # Input: root = [3,9,20,null,null,15,7]
    # Output: [[9],[3,15],[20],[7]]
    def test_case1(self):
        root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right.left = TreeNode(15)
        root.right.right = TreeNode(7)
        expected = [[9], [3, 15], [20], [7]]
        actual = self.sol.verticalOrder(root)
        self.assertEqual(expected, actual)


    def test_case2(self):
        s = "abacab"
        k = 3
        expected = ["bac",  "cab"]
        actual = self.sol.sub_string_k(s, k)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()


