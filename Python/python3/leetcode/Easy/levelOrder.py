import unittest

class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution(unittest.TestCase):
    #other's stylish solution, 48ms
    def levelOrder(self, root):
        if not root:
            return []
        ans, level = [], [root]
        while level:
            ans.append([node.val for node in level])
            temp = []
            for node in level:
                temp.extend([node.left, node.right])
            level = [leaf for leaf in temp if leaf]
        return ans
    #accepted, poor man's solution, 52ms
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = [[root.val]]
        q = [root.left]
        q.append(root.right)
        while True:
            q2, tempRes = [], []
            while q:
                temp = q[0]
                q = q[1:]
                #for some reason I am unaware, I can't use temp = q.pop(), if so, then the order will differ
                if temp:
                    tempRes.append(temp.val)
                    q2.append(temp.left)
                    q2.append(temp.right)
            q = q2
            if not q:
                break
            else:
                res.append(tempRes)
        return res

    def test_levelOrder(self):
        print('starting testing level order traversal')
        r = TreeNode(3)
        r.left = TreeNode(9)
        r.right = TreeNode(20)
        r.right.left = TreeNode(15)
        r.right.right = TreeNode(7)
        res = self.levelOrder(r)
        print('res: %s' % res)
        self.assertTrue(len(res) ==3 and  res[0] == [3] and res[1] == [9,20] and res[2] ==[15,7])

   
        
if __name__ == '__main__':
    unittest.main()
