class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    #accepted, and done by me, beat 25%
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return None
        lst = [root]
        childList = []
        lastChildList = []
        while True:
            if len(lst) == 0: break
            lastChildList= list(lst)
            childList.clear()
            while len(lst) > 0:
                n = lst.pop(0)
                if n.left:
                    childList.append(n.left)
                if n.right:
                    childList.append(n.right)
            lst = list(childList)
        return lastChildList[0].val

    #from the discussion section, not sure if it is good, looks nice                
    def findBottomLeftValue(self, root):
        if not root:
            return

        max_depth = 0
        queue = [(root, 1)]
        
        while queue:
            curr, level = queue.pop(0)
            if curr:
                if level > max_depth:
                    max_depth = level
                    ans = curr.val
                queue.append((curr.left, level + 1))
                queue.append((curr.right, level + 1))
        return ans


root = TreeNode(1)
root.left = TreeNode(3)
root.left.left = TreeNode(7)
root.right = TreeNode(2)
root.right.right = TreeNode(40)
root.left.left.left = TreeNode(100)

sol = Solution()
res = sol.findBottomLeftValue2(root)
print("res: %s" % (res))

