import unittest
from typing import List


class GroupByElements:
    def groupByElements(self, words: List[str]) -> List[List[str]]:
        mp = {}
        for word in words:
            st = sorted(set([x for x in word]))
            key = '_'.join(st)
            if key in mp:
                mp[key].append(word)
            else:
                mp[key] = [word]
        return list(mp.values())


class TestGroupByElements(unittest.TestCase):
    sol = GroupByElements()

    def test_without_dups(self):
        words = ["CAT", "TAC", "EAT", "DEF", "TEA", "TCA"]
        expected = [["CAT", "TAC", "TCA"], ["EAT", "TEA"], ["DEF"]]
        actual = self.sol.groupByElements(words)
        self.assertEqual(expected, actual)
    def test_with_dups(self):
        words = ["CAT", "TAC", "EAT", "TEEEEA", "DEF", "TEA", "TCA", "TACC",]
        expected = [["CAT", "TAC", "TCA", "TACC"], ["EAT", "TEEEEA", "TEA"], ["DEF"]]
        actual = self.sol.groupByElements(words)
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()
