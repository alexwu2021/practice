from typing import List


# 2420. Find All Good Indices
# We call an index i in the range k <= i < n - k good if the following conditions are satisfied:
# The k elements that are just before the index i are in non-increasing order.
# The k elements that are just after the index i are in non-decreasing order.

class GoodIndices:

    def goodIndices(self, a: List[int], k: int) -> List[int]:
        n, ans = len(a), []
        prefix, postfix = [1] * (n + 1), [1] * (n + 1)
        for i in range(1, n):
            if a[i - 1] >= a[i]:
                prefix[i] = prefix[i - 1] + 1

        for i in range(n - 2, -1, -1):
            if a[i] <= a[i + 1]:
                postfix[i] = postfix[i + 1] + 1

        for i in range(k, n - k):
            if prefix[i - 1] >= k and k <= postfix[i + 1]:
                ans.append(i)
        return ans
