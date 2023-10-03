from collections import defaultdict
from typing import List

class NumPais:

    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        d = defaultdict(int)
        ans = 0
        for t in time:
            rem, com = t % 60, -t % 60
            if rem == 0:
                ans += d[rem]
            elif com in d:
                ans += d[com]
            d[rem] += 1
        return ans