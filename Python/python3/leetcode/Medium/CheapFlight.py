from collections import defaultdict
from typing import List
import math
class CheapFlight:

    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        costs = defaultdict(lambda : math.inf)
        costs[src] = 0
        for _ in range(k + 1):
            costcopy = costs.copy()
            for a, b, c in flights:
                if costcopy[b] > costs[a] + c:
                    costcopy[b] = costs[a] + c
            costs = costcopy
        return costs[dst] if costs[dst] != math.inf else -1

n = 3
flights = [[0,1,100],[1,2,100],[0,2,500]]
src = 0
dst = 2
k = 1
expected = 200
actual = CheapFlight().findCheapestPrice(n, flights, src, dst, k)
print("actual: %d" % actual)
assert(expected == actual)

n = 3
flights = [[0,1,100],[1,2,100],[0,2,500]]
src = 0
dst = 2
k = 0
expected = 500
actual = CheapFlight().findCheapestPrice(n, flights, src, dst, k)
print("actual: %d" % actual)
assert(expected == actual)

n = 3
flights = [[0,1,2],[1,2,1],[2,0,10]]
src = 1
dst = 2
k = 1
expected = 1
actual = CheapFlight().findCheapestPrice(n, flights, src, dst, k)
print("actual: %d" % actual)
assert(expected == actual)

n = 4
flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
src = 0
dst = 3
k = 1
expected = 700
actual = CheapFlight().findCheapestPrice(n, flights, src, dst, k)
print("actual: %d" % actual)
assert(expected == actual)
