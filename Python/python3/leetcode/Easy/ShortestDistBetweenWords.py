# Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between the occurrence of these two words in the list.
#
# Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.

from typing import List
class ShortestDistBetweenWords:

    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        w1 = w2 = -1
        ans = 1e9
        for i, v in enumerate(wordsDict):
            if v == word1:
                if word1 == word2 and w1 != -1:
                    ans = min(ans, abs(w1 - i))
                w1 = i
            elif v == word2:
                w2 = i

            if w1 != -1 and w2 != -1:
                ans = min(ans, abs(w1 - w2))

        return ans


wordDict = ["practice", "makes", "perfect", "coding", "makes"]
word1 = "makes"
word2 = "makes"
actual = ShortestDistBetweenWords().shortestWordDistance(wordDict, word1, word2)
expected = 3
assert(expected == actual)