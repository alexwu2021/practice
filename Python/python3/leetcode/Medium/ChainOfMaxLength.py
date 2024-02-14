# 646
# You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
#
# A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
#
# Return the length longest chain which can be formed.
#
# You do not need to use up all the given intervals. You can select pairs in any order.
#
#
#
# Example 1:
#
# Input: pairs = [[1,2],[2,3],[3,4]]
# Output: 2
# Explanation: The longest chain is [1,2] -> [3,4].
# Example 2:
#
# Input: pairs = [[1,2],[7,8],[4,5]]
# Output: 3
# Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

from typing import List
class ChainOfMaxLength:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        # must make all the second values in order, because for pairs[i] and pairs[j] where i < j, we still be able
        # to adjust the condition between pairs[i][1] vs. pairs[j][0]
        pairs.sort(key=lambda x: x[1])

        ans = 1
        current = 1
        last_pair = pairs[0]
        for i in range(1, len(pairs)):
            if last_pair[1] < pairs[i][0]:
                current += 1
                ans = max(ans, current)
                last_pair = pairs[i]
            # surprisingly we needn't update last if no handling
        return ans

    def findLongestChain_dp(self, pairs: List[List[int]]) -> int:
        pairs.sort(key=lambda x: x[0]) # dp based on sorting by the first val
        n = len(pairs)
        dp = [1] * n
        for i in range(1, n):
            dp[i] = max(dp[i], max(1 + dp[j] if pairs[i][0] > pairs[j][1] else 1 for j in range(i))) # j is on the left of i
        return max(dp)
