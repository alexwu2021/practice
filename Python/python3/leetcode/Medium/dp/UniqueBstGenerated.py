# 95.

from typing import List, Optional

from python3.leetcode.common_types import TreeNode


class UniqueBstGenerated:

    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        if n == 0:
            return []

        def dfs(left, right):
            if (left, right) in M:
                return M[(left, right)]

            res = []
            if left > right:
                res.append(None) # need this pruning
                return res

            for v in range(left, right + 1):
                lt, rt = dfs(left, v - 1), dfs(v + 1, right)  # since v is being used as the val for new root, itself should be excluded
                for l in lt:
                    for r in rt:
                        res.append(TreeNode(v, l, r))

            M[(left, right)] = res
            return res

        M = {}
        return dfs(1, n)
