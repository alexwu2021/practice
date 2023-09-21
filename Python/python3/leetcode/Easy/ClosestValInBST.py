from typing import Optional

from python3.leetcode.common_types import TreeNode

# return the smallest closet number
def closestValue(self, root: Optional[TreeNode], target: float) -> int:
    def dfs(node, target, lst):
        if not node: return
        lst.append((abs(node.val - target), node.val))

        if target == node.val:
            return node.val
        if target > node.val:
            dfs(node.right, target, lst)
        else:
            dfs(node.left, target, lst)

    lst = []
    dfs(root, target, lst)

    lst.sort()
    return lst[0][1]