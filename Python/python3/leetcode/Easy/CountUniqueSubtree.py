from typing import Optional
from python3.leetcode.common_types import TreeNode

class CountUniqueSubtree:





    def countUnivalSubtrees(self, root: Optional[TreeNode]) -> int:
        self.count = 0
        def dfs(node):
            if not node:
                return True
            l = dfs(node.left)
            r = dfs(node.right)
            if not l or not r:
                return False
            if node.left and node.left.val != node.val:
                return False
            if node.right and node.right.val != node.val:
                return False
            self.count += 1
            return True
        dfs(root)
        return self.count




    def countUnivalSubtrees_mine(self, root: Optional[TreeNode]) -> int:
        ans = 0
        def dfs(n) -> int:
            nonlocal ans
            if not n: return float('-inf')
            if not n.left and not n.right:
                ans += 1
                return n.val
            if n.left and n.right:
                lval, rval = dfs(n.left), dfs(n.right)
                if lval == rval and rval == n.val:
                    ans += 1
                    return n.val
            if not n.left and n.val == dfs(n.right):
                ans += 1
                return n.val
            if not n.right and n.val == dfs(n.left):
                ans += 1
                return n.val
            return float('-inf')
        dfs(root)
        return ans



root = TreeNode(5)
root.left = TreeNode(1)
# root.right = TreeNode(3)
root.left.left = TreeNode(1)
root.left.right = TreeNode(1)
# root.right.left = TreeNode(1)

actual = CountUniqueSubtree().countUnivalSubtrees_mine(root)
print("actual: %d" % actual)
expected = 3
assert(expected == actual)