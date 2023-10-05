import unittest
from typing import List
from collections import defaultdict, Counter

class ConcatenatedWords:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        ans = []
        if not words: return ans
        s_len, num_words, n, word_counter = len(s), len(words), len(words[0]), Counter(words)
        for i in range(s_len - num_words * n + 1):
            temp = [s[j:j + n] for j in range(i, i + num_words * n, n)]
            if Counter(temp) == word_counter: ans.append(i)
        return ans

class TestConcatenatedWords(unittest.TestCase):
    sol = ConcatenatedWords()

    def test_case1(self):
        s = "barfoothefoobarman"
        words = ["foo", "bar"]
        actual = self.sol.findSubstring(s, words)
        expected = [0, 9]
        self.assertEqual(expected, actual)

    def test_case2(self):
        s = "wordgoodgoodgoodbestword"
        words = ["word", "good", "best", "word"]
        actual = self.sol.findSubstring(s, words)
        expected = []
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()

