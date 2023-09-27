import heapq
from typing import List
from collections import defaultdict

class MinCostMst:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        mh = lambda p1, p2: abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

        n = len(points)
        c = defaultdict(list)
        for i in range(n):
            for j in range(i + 1, n):
                d = mh(points[i], points[j])
                c[i].append((d, j))
                c[j].append((d, i))

        n = len(points)
        c = defaultdict(list)
        for i in range(n):
            for j in range(i + 1, n):
                d = mh(points[i], points[j])
                c[i].append((d, j))
                c[j].append((d, i))

        ans = 0
        visited = [0] * n
        heap = c[0]

        visited[0] = 1
        heapq.heapify(heap)
        while heap:
            d, k = heapq.heappop(heap)
            if not visited[k]:
                visited[k] = 1
                ans += d
                for ele in c[k]:
                    heapq.heappush(heap, ele)
        return ans

