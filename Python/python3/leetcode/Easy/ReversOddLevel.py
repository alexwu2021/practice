from typing import List, Optional

from python3.leetcode.common_types import TreeNode


class ReverseOddLevel:

    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(n1, n2, level):
            if not n1 or not n2: return
            if level % 2 == 1:
                n1.val, n2.val = n2.val, n1.val

            dfs(n1.left, n2.right, level + 1)
            dfs(n1.right, n2.left, level + 1)

        dfs(root.left, root.right, 1)
        return root
