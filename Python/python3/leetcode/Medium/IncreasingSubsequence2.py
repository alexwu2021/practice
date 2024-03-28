from typing import List


class SEG:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * 2 * self.n

    def query(self, l, r):
        l += self.n
        r += self.n
        ans = 0
        while l < r:
            if l & 1:
                ans = max(ans, self.tree[l])
                l += 1
            if r & 1:
                r -= 1
                ans = max(ans, self.tree[r])
            l >>= 1
            r >>= 1
        return ans

    def update(self, i, val):
        i += self.n
        self.tree[i] = val
        while i > 1:
            i >>= 1
            self.tree[i] = max(self.tree[i * 2], self.tree[i * 2 + 1])


class IncreasingSubsequence2:
    def lengthOfLIS(self, A: List[int], k: int) -> int:
        n, ans = max(A), 1
        seg = SEG(n)
        for a in A:
            a -= 1
            premax = seg.query(max(0, a - k), a)
            ans = max(ans, premax + 1)
            seg.update(a, premax + 1)
        return ans

nums = [7,4,5,1,8,12,4,7]
k = 5
actual = IncreasingSubsequence2().lengthOfLIS(nums, k)
print(f"actual: {actual}")
assert actual == 4

nums = [4,2,1,4,3,4,5,8,15]
k = 3
actual = IncreasingSubsequence2().lengthOfLIS(nums, k)
print(f"actual: {actual}")
assert actual == 5
