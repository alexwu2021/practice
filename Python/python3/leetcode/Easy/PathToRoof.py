from typing import List, Optional

from python3.leetcode.common_types import TreeNode


def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
    ans = []

    def dfs(n, path):
        nonlocal ans
        if not n:
            return
        if not n.left and not n.right:
            ans.append(path + [str(n.val)])
            return
        dfs(n.left, path + [str(n.val)])
        dfs(n.right, path + [str(n.val)])

    dfs(root, [])
    return [ *map('->'.join, ans) ]  # map(fun, iter)