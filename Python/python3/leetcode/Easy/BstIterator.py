from typing import Optional
from python3.leetcode.common_types import TreeNode

class BstInterator:
    def __init__(self, root: Optional[TreeNode]):
        self.iter = self.inorder_traverse(root)
        self.next2 = next(self.iter, None)  # next is Python function, while next2 is mine

    def inorder_traverse(self, n):
        if n:
            yield from self.inorder_traverse(n.left)
            yield n.val
            yield from self.inorder_traverse(n.right)

    def next(self):
        res = self.next2
        self.next2 = next(self.iter, None)
        return res

    def hasNext(self):
        return self.next2 is not None
