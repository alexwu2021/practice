from python3.leetcode.common_types import TreeNode

import bisect
class PreorderToBst:
    def bstFromPreorder(self, A):
        def helper(i, j):
            if i == j:
                return None
            root = TreeNode(A[i])
            mid = bisect.bisect(A, A[i], i + 1, j)
            root.left = helper(i + 1, mid)
            root.right = helper(mid, j)
            return root

        return helper(0, len(A))
