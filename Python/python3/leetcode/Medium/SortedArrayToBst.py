from typing import List, Optional

from python3.leetcode.common_types import TreeNode


class SortedArrayToBst:

    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def dfs(node, vals) -> TreeNode:
            if vals:
                mid = len(vals) // 2
                node.val = vals[mid]
                node.left = dfs(TreeNode(), vals[:mid])
                node.right = dfs(TreeNode(), vals[mid + 1:])
                return node
        root = TreeNode()
        dfs(root,nums)
        return root


    def sortedArrayToBST_simpleSyntax(self, nums: List[int]) -> Optional[TreeNode]:
        def dfs(node, vals) -> TreeNode:
            if vals:
                mid = len(vals) // 2
                node.val = vals[mid]
                node.left, node.right = dfs(TreeNode(), vals[:mid]), dfs(TreeNode(), vals[mid + 1:])
                return node

        return dfs(TreeNode(), nums)
