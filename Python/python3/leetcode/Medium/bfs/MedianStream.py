import heapq
from typing import List
class MedianStream:
    def median(self, nums : List[int], k : int) -> List[int]:
        res = [0] * k
        nq = [], xq = []
        for i in range(len(nums)):
            num = nums[i]
            heapq.heappush(nq, -num) # always insert to min heap
            heapq.heappush(xq, heapq.heappop(nq)) # and let xq take the ripple

            if len(nq) < len(xq): # re-balancing
                heapq.heappush(nq, heapq.heappop(xq))

            if len(nq) == len(xq):
                res[i] = (nq[0] + xq[1]) / 2

            if len(nq) > len(xq):
                res[i] = nq[0]
            else:
                res[i] = xq[0]

        return res

