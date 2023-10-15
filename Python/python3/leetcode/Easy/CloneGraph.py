class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors


class CloneGraph:

    def cloneGraph(self, node):
        visited = {}

        def dfs(node):
            if not node:
                return node
            if node in visited:
                return visited[node]
            clone_node = Node(node.val, [])
            visited[node] = clone_node
            if node.neighbors:
                clone_node.neighbors = [dfs(n) for n in node.neighbors]
            return clone_node

        return dfs(node)
