class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# 99
# You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were
# swapped by mistake. Recover the tree without changing its structure.
class MorrisTreeTraverse:

    def recoverTree(self, root: TreeNode) -> None:
        self.prev = None  # previous node
        bads = [None] * 2  # the two bad nodes

        def dfs(n):  # depth first search
            if n.left:
                dfs(n.left)
            if self.prev and n.val < self.prev.val:  # found bad place
                if not bads[0]:  # found bad place the 1st time
                    bads[0] = self.prev
                    bads[1] = n
                else:  # found bad place the 2nd time
                    bads[1] = n
                    return
            self.prev = n
            if n.right:
                dfs(n.right)

        dfs(root)
        bads[0].val, bads[1].val = bads[1].val, bads[0].val