class RAndA:

    def findMin(self, s: str, a: int, b: int) -> str:
        def add(s, a):
            new = ""
            for i in range(len(s)):
                if i % 2 != 0:
                    new += str(int(s[i]) + a)[-1]
                else:
                    new += s[i]
            return new

        def rotate(s, b):
            return s[len(s) - b:] + s[:len(s) - b]


        visited, running = set(), list()
        running.append(s)
        while running:
            curr = running.pop()
            if curr not in visited:
                visited.add(curr)
                running.extend([add(curr, a), rotate(curr, b)])
        return min(visited)