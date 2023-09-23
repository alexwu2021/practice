from typing import List
from collections import defaultdict


def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
    count = n
    if count == 1:
        return [0]

    dd = defaultdict(set)
    for s, e in edges:
        dd[s].add(e)
        dd[e].add(s)

    lfs = [node for node in dd if len(dd[node]) == 1]
    while count > 2:
        count -= len(lfs)
        next = []
        for lf in lfs:
            nei = dd[lf].pop()
            dd[nei].remove(lf)
            if len(dd[nei]) == 1:
                next.append(nei)
        lfs = next
    return lfs
