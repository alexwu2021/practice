# 864

from collections import deque
from string import ascii_lowercase, ascii_uppercase
from typing import List

# You are given an m x n grid grid where:
#
# '.' is an empty cell.
# '#' is a wall.
# '@' is the starting point.
# Lowercase letters represent keys.
# Uppercase letters represent locks.
# You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
#
# If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
#
# For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
#
# Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

class ShortestPathAllKeys:


    def shortestPathAllKeys(self, G: List[str]) -> int:
        G = [list(row) for row in G]
        likely_keys, likely_locks = set(ascii_lowercase), set(ascii_uppercase)
        n_keys = sum(1 for row in G for elm in row if elm in likely_keys)
        s_r, s_c = [(i, j) for i, row in enumerate(G) for j, a in enumerate(row) if a == '@'][0]
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        m, n = len(G), len(G[0])
        start_keys = frozenset() if G[s_r][s_c] not in likely_keys else frozenset(G[s_r][s_c][0])
        visited = {(s_r, s_c, start_keys)}
        q = deque([(0, s_r, s_c, start_keys)])
        while q:
            steps, i, j, keys = q.popleft()
            if len(keys) == n_keys:
                return steps
            for dx, dy in directions:
                newx, newy = i + dx, j + dy
                if 0 <= newx < m and 0 <= newy < n and (newx, newy, keys) not in visited and G[newx][newy] != '#':
                    visited.add((newx, newy, keys))
                    if G[newx][newy] in '.@': # move with no impediment
                        q.append((steps + 1, newx, newy, keys))
                    elif G[newx][newy] in likely_locks and G[newx][newy].lower() in keys: # unlock and move
                        q.append((steps + 1, newx, newy, keys))
                    elif G[newx][newy] in likely_keys: # pick up a key and move
                        next_keys = frozenset(set(keys) | set(G[newx][newy]))
                        q.append((steps + 1, newx, newy, next_keys))
        return -1

grid = ["@.a..","###.#","b.A.B"]
actual = (ShortestPathAllKeys().shortestPathAllKeys(grid))
expected = 8
assert(expected == actual)


grid = ["@..aA","..B#.","....b"]
actual = (ShortestPathAllKeys().shortestPathAllKeys(grid))
expected = 6
assert(expected == actual)
