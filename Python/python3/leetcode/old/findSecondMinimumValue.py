
class Solution(object):
    def dfs(self, node):
        if not node: return
        if root.val < node.val < self.res:
            self.res = node.val
        self.dfs(node.left)
        self.dfs(node.right)

    #it has an assumption that the root contains the smallest value
    def findSecondMinimumValue(self, root):
        self.res = float('inf')
        self.dfs(root)
        if self.res == float('inf'):
            return -1
        return self.res


    #i like this one more just because there is no assumption
    #that the root has the smallest value
    def findSecondMinimumValue(self, root):
        def dfs(node):
            if node:
                uniques.add(node.val)
                dfs(node.left)
                dfs(node.right)

        uniques = set()
        dfs(root)

        min1, ans = root.val, float('inf')
        for v in uniques:
            if min1 < v < ans:
                ans = v

        return ans if ans < float('inf') else -1
