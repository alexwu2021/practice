import collections


class DLinkedListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.freq = 1
        self.prev = self.next = None


class DLinkedList:
    def __init__(self):
        self._sentinel = DLinkedListNode(None, None)  # dummy node
        self._sentinel.next = self._sentinel.prev = self._sentinel
        self._size = 0

    def __len__(self):
        return self._size

    def append(self, node):
        node.next = self._sentinel.next
        node.prev = self._sentinel
        node.next.prev = node
        self._sentinel.next = node
        self._size += 1

    def pop(self, node=None):
        if self._size == 0:
            return

        if not node:
            node = self._sentinel.prev

        node.prev.next = node.next
        node.next.prev = node.prev
        self._size -= 1

        return node


class LFUCache:
    def __init__(self, capacity):
        self._size = 0
        self._capacity = capacity

        self.mpKey2Node = dict()  # key: Node
        self.mpFreq2List = collections.defaultdict(DLinkedList)
        self._minfreq = 0

    def _update(self, node):
        freq = node.freq

        self.mpFreq2List[freq].pop(node)
        if self._minfreq == freq and not self.mpFreq2List[freq]:
            self._minfreq += 1

        node.freq += 1
        freq = node.freq
        self.mpFreq2List[freq].append(node)

    def get(self, key):
        if key not in self.mpKey2Node:
            return -1

        node = self.mpKey2Node[key]
        self._update(node)
        return node.val

    def put(self, key, value):
        if self._capacity == 0:
            return

        if key in self.mpKey2Node:
            node = self.mpKey2Node[key]
            self._update(node)
            node.val = value
            return

        if self._size == self._capacity:
            node = self.mpFreq2List[self._minfreq].pop()
            del self.mpKey2Node[node.key]
            self._size -= 1

        node = DLinkedListNode(key, value)
        self.mpKey2Node[key] = node
        self.mpFreq2List[1].append(node)
        self._minfreq = 1
        self._size += 1