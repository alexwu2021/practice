import unittest

placeHolder = ' null '
class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None
     def __repr__(self):
        """ return the repr recursively
        """
        ret = str(self.val) + ' ' 
        if self.left:
            ret += self.left.__repr__()
        else:
            ret += placeHolder
        ret += ' '
        if self.right:
            ret += self.right.__repr__()
        else:
            ret += placeHolder
        return ret

class Solution(unittest.TestCase):
    #accepted, 49 ms, beats 31%
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        if not root.left and not root.right:
            return
        if root.left and not root.right:
            self.flatten(root.left)
            root.right = root.left
            root.left = None
            return
        if not root.left and root.right:
            self.flatten(root.right)
            return
        temp = root.right
        self.flatten(root.left)
        root.right = root.left
        root.left = None
        curr = root
        while curr.right:
            curr = curr.right
        self.flatten(temp)
        curr.right = temp
        

    def test_levelOrder(self):
        print('starting testing flatten')
        r = TreeNode(1)
        r.left = TreeNode(2)
        r.right = TreeNode(3)
        
        self.flatten(r)
        print('res: %s' % str(r))
        #self.assertTrue(res== [1,null,2,null,3])

   
        
if __name__ == '__main__':
    unittest.main()
