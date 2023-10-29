
from typing import List
class BeautifulTower2:
    def maximumSumOfHeights(self, A: List[int]) -> int:
        n = len(A)

        # calc the left and stack
        left = [0] * n
        stack = [-1]
        cur = 0
        for i in range(n):
            while len(stack) > 1 and A[stack[-1]] > A[i]:
                j = stack.pop()
                cur -= (j - stack[-1]) * A[j]
            cur += (i - stack[-1]) * A[i]
            stack.append(i)
            left[i] = cur

        stack = [n]
        res = cur = 0

        # check for each element to update res with max
        for i in range(n - 1, -1, -1):
            while len(stack) > 1 and A[stack[-1]] > A[i]:
                j = stack.pop()
                cur -= -(j - stack[-1]) * A[j]

            cur += -(i - stack[-1]) * A[i]
            stack.append(i)

            res = max(res, left[i] + cur - A[i])

        return res

    def maximumSumOfHeights_tle(self, A: List[int]) -> int:
        res = 0
        n = len(A)
        for i in range(n):
            cur = v = A[i]
            for j in range(i - 1, -1, -1):
                v = min(v, A[j])
                cur += v
            v = A[i]
            for j in range(i + 1, n):
                v = min(v, A[j])
                cur += v
            res = max(res, cur)
        return res