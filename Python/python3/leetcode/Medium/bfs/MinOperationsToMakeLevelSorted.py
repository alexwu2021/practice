
from typing import Optional

from python3.leetcode.common_types import TreeNode


class MinOperationsToMakeLevelSorted:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        # minimum swaps required to swap any array
        def minSwaps(arr):
            n = len(arr)
            arrpos = [*enumerate(arr)]
            arrpos.sort(key=lambda it: it[1])
            vis = {k: False for k in range(n)}

            ans = 0
            for i in range(n):
                if vis[i] or arrpos[i][0] == i:
                    continue
                cycle_size = 0
                j = i

                while not vis[j]:
                    vis[j] = True
                    j = arrpos[j][0]
                    cycle_size += 1
                if cycle_size > 0:
                    ans += (cycle_size - 1)
            return ans

        # level order traversal of tree (level by level)
        queue = [root]
        ans = 0
        while queue:
            lst = []
            for i in range(len(queue)):
                temp = queue.pop(0)
                lst.append(temp.val)
                if temp.left:
                    queue.append(temp.left)
                if temp.right:
                    queue.append(temp.right)
            if len(lst) > 1:
                ans += minSwaps(lst)  # add minimum swapping required for all the array
        return ans

sol = MinOperationsToMakeLevelSorted()


# [1,4,3, 7,6, 8,5,null,null,null,null,9,null,10]
root = TreeNode(1)
root.left = TreeNode(4)

root.left.left = TreeNode(7)
root.left.left = TreeNode(6)

root.right = TreeNode(3)
root.right.left = TreeNode(8)
root.right.right = TreeNode(5)


root.right.left.left = TreeNode(9)
root.right.right.left = TreeNode(10)


actual = sol.minimumOperations(root)
assert(3 == actual)