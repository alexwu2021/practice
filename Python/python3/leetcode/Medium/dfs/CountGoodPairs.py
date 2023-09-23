# 1530. Number of Good Leaf Nodes Pairs

# could number of good leaf node pairs
# a good pair is one whose distance is less than the given k

from python3.leetcode.common_types import TreeNode


class CountGoodPairs:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.ans = 0

        def dfs(root):
            if not root: return []
            if not root.left and not root.right: return [1]

            lefts = dfs(root.left)
            rights = dfs(root.right)
            for i in lefts:
                for j in rights:
                    if i + j <= distance:
                        self.ans += 1

            return [i + 1 for i in lefts + rights if i + 1 < distance]

        dfs(root)
        return self.ans