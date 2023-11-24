from typing import List

# 1014 best sight seeing pair

class Sightseeting:

    # Try to think about rearranged formula, (values[i] + i) + (values[j] - j) instead of values[i] + values[j] + i - j.
    def maxScoreSightseeingPair(self, A: List[int]) -> int:
        ans = cur = 0
        for a in A:
            ans = max(ans, cur + a)
            cur = max(cur, a) - 1  # when we move forward, all sightseeing spot we have seen will be 1 distance further.
        return ans