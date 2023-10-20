from collections import Counter


class LongestSubstringOfKFrequency:

    def longestSubstring(self, s: str, k: int) -> int:
        if len(s) == 0 or k > len(s):
            return 0
        c = Counter(s)
        for i, char in enumerate(s):
            # the dividing point
            if c[char] < k:
                return max(self.longestSubstring(s[:i], k), self.longestSubstring(s[i + 1:], k))
        return len(s)


l = LongestSubstringOfKFrequency()
s = "aab"
k = 2
expected = 2
actual = l.longestSubstring(s, k)
assert (expected == actual)

s = "ababbc"
k = 2
expected = 5
actual = l.longestSubstring(s, k)
assert (expected == actual)
