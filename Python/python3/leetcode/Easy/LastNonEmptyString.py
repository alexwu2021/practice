
from collections import Counter
class LastNonEmptyString:
    def lastNonEmptyString(self, s: str) -> str:
        res = []
        c = Counter(s)
        mx = max(y for y in c.values())
        for ch in reversed(s):
            if c[ch] == mx:
                res.append(ch)
                c[ch] = -1
        return ''.join(res[::-1])
# #
s = "aabcbbcad"
actual = LastNonEmptyString().lastNonEmptyString(s)
expected = "ba"
assert(expected == actual)

s = "abcd"
actual = LastNonEmptyString().lastNonEmptyString(s)
expected = "abcd"
assert(expected == actual)


s ="qmdqhzazrhdhmmazzhzz"
actual = LastNonEmptyString().lastNonEmptyString(s)
expected = "z"
assert(expected == actual)
