# 1081. Smallest Subsequence of Distinct Characters
from collections import Counter
class DistinctCharacterSequence:

    def smallestSubsequence(self, s: str) -> str:
        counter = Counter(s)
        stack = []
        v = set()
        for c in s:
            counter[c] -= 1
            if c in v: continue
            while stack and counter[stack[-1]] > 0 and stack[-1] > c:
                v.remove(stack.pop())
            stack.append(c)
            v.add(c)
        return "".join(stack)
