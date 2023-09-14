# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        def doit(node):
            if node:
                vals.append(str(node.val))
                doit(node.left)
                doit(node.right)
            else:
                vals.append('#')
        vals = []
        doit(root)
        return ' '.join(vals)

    def deserialize(self, data):
        def doit():
            val = next(vals)
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node
        vals = iter(data.split())
        return doit()
    
    def serialize_mine(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def dfs(node):
            if not node:
                return "#"
            ret = [str(node.val)]
            ret.append(dfs(node.left))
            ret.append(dfs(node.right))
            return ' '.join(ret)
        return dfs(root)

    def deserialize_mine(self, dat):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def dfs2(data, i):
            if i < len(data):
                if str(data[i]) != "#":
                    t = TreeNode(int(data[i]))
            if 2 *i + 1 < len(data):
                if data[2*i] != "#":
                    t.left = dfs2(data, 2* i)
                if data[2*i + 1] != "#":
                    t.right = dfs2(data, 2*i + 1)
            return t
        data = list(dat.split(' '))
        return dfs(data, 0)
            
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))