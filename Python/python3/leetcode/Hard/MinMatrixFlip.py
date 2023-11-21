import collections


class MinMatrixFlip:
    def minFlips(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: int
        """

        m = len(mat)
        n = len(mat[0])

        def getInitialState(mat, m, n):
            state = 0b0
            for r in range(m):
                for c in range(n):
                    state |= mat[r][c] << (r * n + c)

            return state

        q = collections.deque()
        seen = set()

        initial = getInitialState(mat, m, n)
        q.append((initial, 0))
        seen.add(initial)

        while q:
            state, steps = q.popleft()

            if state == 0:
                return steps

            for r in range(m):
                for c in range(n):
                    bit_flip = 1 << (r * n + c)
                    for d in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                        nr = r + d[0]
                        nc = c + d[1]
                        if nr < 0 or nc < 0 or nr >= m or nc >= n:
                            continue
                        bit_flip |= 1 << (nr * n + nc)
                    nextstate = state ^ bit_flip

                    if nextstate not in seen:
                        q.append((nextstate, steps + 1))
                        seen.add(nextstate)

        return -1
