class MyHashMap:

    def __init__(self):
        self.keys = []
        self.vals = []

    def put(self, key: int, value: int) -> None:
        for i, v in enumerate(self.keys):
            if v == key:
                self.vals[i] = value
                return
        self.keys += [key]
        self.vals += [value]

    def get(self, key: int) -> int:
        for i, v in enumerate(self.keys):
            if v == key:
                return self.vals[i]
        return -1

    def remove(self, key: int) -> None:
        idx = -1
        for i, v in enumerate(self.keys):
            if v == key:
                idx = i
                break
        self.keys = self.keys[:idx] + self.keys[idx + 1:]
        self.vals = self.vals[:idx] + self.vals[idx + 1:]

sol = MyHashMap()
sol.put(1, 2)
sol.put(2, 4)
sol.remove(2)
retrieved = sol.get(2)
print(retrieved)