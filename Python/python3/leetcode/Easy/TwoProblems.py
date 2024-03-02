from typing import List
from collections import Counter

def getIndices(s, words) -> List[int]:
    def canUseUpFreq(ss, dd): # check to see if all the remaining frequency of words can be used up
        for i in range(0, len(ss), k):
            v = ss[i:i+k]
            if v not in dd:
                return False
            else:
                if dd[v] <= 0:
                    return False
                dd[v] -= 1
        return all(v == 0 for v in dd.values())

    ans = []
    d = Counter(words)
    n = len(s)
    k = len(words[0])
    maxLen = k * len(words)

    for i in range(0, len(s), k):
        v = s[i:i+k]
        if i + maxLen > n: # early pruning
            continue
        if v not in d.keys():
            continue
        dd = d.copy()

        dd[v] -= 1
        if canUseUpFreq(s[i+k:maxLen], dd):
            ans.append(i)
    return ans


words = ["word", "good", "best", "word"]
s1 = "wordgoodgoodgoodbestword"
actual = getIndices(s1, words)
expected = []
assert(expected == actual)


words = ["foo", "bar"]
s2 = "barfoothefoobarman"
actual = getIndices(s2, words)
expected = [0, 9]
assert(expected == actual)



def maxLength(s):
    n = len(s)
    def dfs(i, j):
        while i < n and s[i] < '(':
            i += 1
        if j <= i:
            return 0

        v1 = v2 = v3 = 0

        if s[j] == ')': # use the two sides
            v1 = 2 + dfs(i+1, j-1)
        elif i + 1  < j and  s[i + 1] == ')': # use the next if it is ')'
            v2 = 2 + dfs(i+2, j)
        else: # just proceed to explore
            v3 = dfs(i + 2, j)
        return max(v1, v2, v3)
    return dfs(0, len(s)-1)


s = ""
actual = maxLength(s)
expected = 0
assert(expected == actual)

s = "(()"
actual = maxLength(s)
expected = 2
assert(expected == actual)

s = "((()))"
actual = maxLength(s)
expected = 6
assert(expected == actual)
