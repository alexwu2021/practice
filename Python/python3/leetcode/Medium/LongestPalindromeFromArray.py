from typing import List
import collections
class LongestPalindromeFromArray:
    def longestPalindrome(self, words: List[str]) -> int:
        d = collections.defaultdict(int)
        for w in words:
            d[w] += 1

        ans = 0
        for w in words:
            if w[0] != w[1]:
                rev = w[::-1]
                print(f"rev: {rev} for w: {w}")
                if d[w] >= 1 and d[rev] >= 1:
                    ans += 4
                    d[w] -= 1
                    d[rev] -= 1
        if any(d[w] >= 1 for w in words if w[0] == w[1]):
            ans += 2
        return ans



words = ["lc","cl","gg"]
actual = LongestPalindromeFromArray().longestPalindrome(words)
expected = 6
assert (expected == actual)