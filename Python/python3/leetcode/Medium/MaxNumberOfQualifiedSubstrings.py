from collections import Counter, defaultdict

class MaxNumberOfQualifedSubstrings:
    def maxFreq(self, s: str, m: int, lo: int, hi: int) -> int:

        cnt = Counter()
        d = defaultdict(int)
        print("s[:lo]: %s" % s[:lo])

        j = 0
        for i, v in enumerate(s):
            cnt[v] += 1
            if i - j + 1 < lo:
                continue

            if hi >= i - j + 1 >= lo:
                if len(cnt.keys()) <= m:
                    d[s[i:j]] += 1
                else:
                    while j < i and len(cnt.keys) > m:
                        cnt[s[j]] -= 1
                        j += 1

            elif i - j + 1 < lo:
                continue
            else:  # i - j + 1 > hi
                if j < i:
                    cnt[s[j]] -= 1
                    j += 1

        return max(list(d.values()) + [0])


s = "aababcaab"
maxLetters = 2
minSize = 3
maxSize = 4
actual = MaxNumberOfQualifedSubstrings().maxFreq(s, maxLetters, minSize, maxSize)
expected = 2
assert(expected == actual)