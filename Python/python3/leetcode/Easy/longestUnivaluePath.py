import sys, unittest


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(unittest.TestCase):
    #accepted
    def longestUnivaluePath(self, root):
        self.mx = 0
        def dfs(node):
            if not node: return 0
            llen, rlen = dfs(node.left), dfs(node.right)
            lpath = rpath = 0
            if node.left and node.left.val == node.val:
                lpath = llen + 1
            if node.right and node.right.val == node.val:
                rpath = rlen + 1
            self.mx = max(self.mx, lpath + rpath)
            return max(lpath, rpath)

        dfs(root)
        return self.mx



    def test_longestUnivaluePath(self):
        root = TreeNode(5)
        root.left = TreeNode(5)
        root.right = TreeNode(3)
        root.left.left = TreeNode(5)
        root.right.left = TreeNode(3)
        res = self.longestUnivaluePath(root)
        print('res: %s' % res)
        #self.assertTrue(res == 3)

        root.right.right = TreeNode(3)
        root.right.right.right= TreeNode(3)
        res = self.longestUnivaluePath(root)
        print('res: %s' % res)
        #self.assertTrue(res == 3) 



if __name__ == '__main__':
    unittest.main()
