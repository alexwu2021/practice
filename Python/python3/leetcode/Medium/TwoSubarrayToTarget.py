# You are given an array of integers arr and an integer target.
#
# You have to find two non-overlapping sub-arrays of arr each with a sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
#
# Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
#


from typing import List
from collections import deque, defaultdict
from math import inf


class TwoSubarrayToTarget:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        ans = inf
        i = window = 0
        dq = deque([(-1, inf)])
        for j, num in enumerate(arr):
            window += num
            while window > target:
                window -= arr[i]
                i += 1
            if window == target:
                curr = j - i + 1
                n = 0
                for index, length in dq:
                    if index < i:
                        n = length
                        break
                ans = min(ans, curr + n)
                if curr < dq[0][1]:
                    dq.appendleft((j, curr))
        return ans if ans < inf else -1

    # below is a slow but concise version
    def minSumOfLengths_slow(self, arr: List[int], target: int) -> int:

        def get_sub_arrays(arr):
            lookup = defaultdict(int)
            running_sum = 0
            dp = [float('inf')] * len(arr)

            for i, num in enumerate(arr):
                running_sum += num
                if running_sum == target:
                    dp[i] = i - 0 + 1
                elif running_sum - target in lookup:
                    dp[i] = i - lookup[running_sum - target] + 1
                lookup[running_sum] = i + 1
                dp[i] = min(dp[i - 1], dp[i])
            return dp

        dp_left = get_sub_arrays(arr)
        dp_right = get_sub_arrays(arr[::-1])[::-1]

        ans = float('inf')
        for i in range(1, len(arr)):
            ans = min(ans, dp_left[i - 1] + dp_right[i])
        return ans if ans != float('inf') else -1
