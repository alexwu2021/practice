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

    #although this one passed my unit test, it failed oj, so i decided to go with the accepted one
    #the main concern is that they do this: self.mx = max(self.mx, lpath + rpath)
    def longestUnivaluePath2(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.mx = -sys.maxsize
        if not root:
            return self.max
        def traverse(node, vpath):
            if node is None:
                return
            if node.left is None and node.right is None:
                if node.val != vpath[0]:
                    self.mx = max(self.mx, 1)
                else:
                    self.mx = max(self.mx, vpath[1] + 1)
                return
            if node.left :
                if node.val == vpath[0]:
                    traverse(node.left, (node.val, vpath[1] + 1))
                else:
                    traverse(node.left, (node.val, 1))
            if node.right:
                if node.val == vpath[0]:
                    traverse(node.right, (node.val, vpath[1] + 1))
                else:
                    traverse(node.right, (node.val, 1))
        traverse(root, (root.val, 0))
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
