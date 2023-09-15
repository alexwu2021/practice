# 1029. Two City Scheduling

# A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
#
# Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.


from typing import List
class TwoCityScheduling:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        a = sorted(costs, key=lambda x: x[0] - x[1])
        sm, ln = 0, len(a)
        for i in range(ln // 2):
            sm += a[i][0]
        for i in range(ln //2, ln):
            sm += a[i][1]
        return sm