from typing import List
from collections import defaultdict


# invariant: guaranteed that there exists such an odd string in the input
def oddString(self, words: List[str]) -> str:
    eq = defaultdict(list)
    for w in words:
        diff = [ord(a) - ord(b) for a, b in zip(w[:-1], w[1:])] # good
        eq[tuple(diff)].append(w) # no use of string!

    for _, ws in eq.items():
        if len(ws) == 1:
            return ws[0]


words = ["adc", "wzy", "abc"]
assert (oddString(words) == "abc")
