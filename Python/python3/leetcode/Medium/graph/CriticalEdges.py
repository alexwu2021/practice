from typing import List

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, p):
        if self.parent[p] == p:
            return p
        self.parent[p] = self.find(self.parent[p])
        return self.parent[p]

    def union(self, u, v):
        self.parent[self.find(u)] = self.parent[self.find(v)]

# 1489 find critical and pseduo critical edges in mst
class CriticalEdges:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        critical, pseudo_critical = [], []
        for i in range(len(edges)):
            edges[i].append(i)
        edges.sort(key=lambda x: x[2])

        mst_wt = self.get_weight(n, edges, -1, -1)
        for i in range(len(edges)):
            if mst_wt < self.get_weight(n, edges, i, -1):
                critical.append(edges[i][3])
            elif mst_wt == self.get_weight(n, edges, -1, i):
                pseudo_critical.append(edges[i][3])
        return [critical, pseudo_critical]

    def get_weight(self, n, edges, block, e):
        uf = UnionFind(n)
        weight = 0
        if e != -1:
            weight += edges[e][2]
            uf.union(edges[e][0], edges[e][1])

        for i in range(len(edges)):
            if i == block:
                continue
            if uf.find(edges[i][0]) == uf.find(edges[i][1]):
                continue
            uf.union(edges[i][0], edges[i][1])
            weight += edges[i][2]

        for i in range(n):
            if uf.find(i) != uf.find(0):
                return float('inf')
        return weight