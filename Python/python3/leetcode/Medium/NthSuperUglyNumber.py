import heapq
from typing import List

# 313.

class NthSuperUglyNumber:

    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        nums = primes.copy()
        heapq.heapify(nums)
        p = 1
        for i in range(n - 1):

            p = heapq.heappop(nums)
            for prime in primes:
                heapq.heappush(nums, p * prime)
                # nums += [p * prime]  // can not do this, since we can not maintain numbers in order between iterations
                if p % prime == 0: # this is the sentinel, w/o it the order will break
                    break
        return p
