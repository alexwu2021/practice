from collections import defaultdict
from typing import List
import unittest
class WordLadder2:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        def backtrack(a, i, child):
            if i:
                a[i] = child
                parents = iter(levels[i][child])
                i -= 1
                _p = next(parents)
                for p in parents:
                    backtrack(a[:], i, p)
                backtrack(a, i, _p)
            else:
                a[0] = beginWord
                ans.append(a)

        def bridges(w):
            for i in range(len(w)):
                yield w[:i] + '_' + w[i + 1:]

        ans = []

        adjacent = defaultdict(list)
        for w in wordList:
            for b in bridges(w):
                adjacent[b].append(w)


        levels = [{beginWord: set()}]
        for _ in range(len(wordList)):
            done = False
            parents = defaultdict(set)
            for parent in levels[-1].keys():
                for b in bridges(parent):
                    for child in adjacent[b]:
                        done |= child == endWord
                        parents[child].add(parent)
            levels.append(parents)
            if done:
                l = len(levels)
                backtrack([None] * l, l - 1, endWord)
                break

        return ans

expected = [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
actual = WordLadder2().findLadders(beginWord="hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"])
assert(len(expected) == len(actual))
for e in expected:
    assert (e in actual)
for a in actual:
    assert(a in expected)