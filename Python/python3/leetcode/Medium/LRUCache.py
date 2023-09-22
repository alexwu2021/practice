
class LRUCache:

    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.prev = None
            self.next = None

    def __init__(self, capacity: int):
        self.cap = capacity
        self.head = self.Node(-1, -1)
        self.tail = self.Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.mp = {}   # key to node map

    def add_node(self, node):
        temp = self.head.next
        node.next = temp

        node.prev = self.head
        self.head.next = node

        temp.prev = node

    def delete_node(self, target):
        prev = target.prev
        next = target.next
        prev.next = next
        next.prev = prev

    def get(self, key: int) -> int:
        if key in self.mp:
            node_found = self.mp[key]
            ans = node_found.val
            del self.mp[key]

            # hoist to the first val node position
            self.delete_node(node_found)
            self.add_node(node_found)
            self.mp[key] = self.head.next

            return ans
        return -1

    def put(self, key: int, value: int) -> None:
        # adjust if the key is in map
        if key in self.mp:
            curr = self.mp[key]
            del self.mp[key]
            self.delete_node(curr)

        # capacity may trigger adjustment: delete the last val node
        if len(self.mp) == self.cap:
            del self.mp[self.tail.prev.key]
            self.delete_node(self.tail.prev)

        # store
        self.add_node(self.Node(key, value))
        self.mp[key] = self.head.next
