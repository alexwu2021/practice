from typing import List
from collections import Counter
class CountOfMaxFreq:

    def maxFrequencyElements(self, nums: List[int]) -> int:
        c = Counter(nums)
        mx = max(c.values())
        ans = 0
        for _, v in c.items():
            if v  == mx:
                ans += v
        return ans



nums = [1,2,2,3,1,4]
actual = CountOfMaxFreq().maxFrequencyElements(nums)
assert(actual == 4)