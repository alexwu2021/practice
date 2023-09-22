from collections import defaultdict

class TrieImpl:
    def __init__(self):
        self.store = []
        self.mp = defaultdict()

    def insert(self, word: str) -> None:
        self.store.append(word)
        for i in range(len(word)):
            self.mp[word[:i + 1]] = 0

    def search(self, word: str) -> bool:
        return True if word in self.store else False

    def startsWith(self, prefix: str) -> bool:
        return True if prefix in self.mp else False