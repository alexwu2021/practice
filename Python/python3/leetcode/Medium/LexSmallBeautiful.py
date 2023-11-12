class LexSmallBeautiful:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        i, j, n, ans = 0, 0, len(s), ""
        count = 0
        j = 0
        while j < n:
            if s[j] == '1':
                count += 1
                if count == k:
                    if ans == "":
                        ans = s[i:j + 1]
            while count > k:
                if s[i] == '1':
                    count -= 1
                i += 1

            while count == k and s[i] == '0':
                i += 1

            if count == k:
                cand = s[i:j + 1]
                if len(cand) < len(ans):
                    ans = cand
                    if cand < ans:
                        ans = cand
                elif len(cand) == len(ans):
                    if cand < ans:
                        ans = cand
            j += 1
        print(ans)
        return ans


s = "100011001"
k = 3
expected = "11001"
actual = LexSmallBeautiful().shortestBeautifulSubstring(s, k)
assert(expected == actual)

s = "1100100101011001001"
k = 7
actual = LexSmallBeautiful().shortestBeautifulSubstring(s, k)
expected =  "1100100101011"
assert(expected == actual)


s = "001110101101101111"
k = 10
actual = LexSmallBeautiful().shortestBeautifulSubstring(s, k)
expected =  "10101101101111"
assert(expected == actual)
