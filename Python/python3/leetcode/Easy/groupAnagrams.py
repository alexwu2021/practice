import unittest

from collections import defaultdict

class Solution(unittest.TestCase):
    #this one is accepted
     def groupAnagrams(self, strs):
        anas = {}
        for string in strs:
            s = ''.join(sorted(string))
            if s in anas:
                anas[s].append(string)
            else:
                anas[s] = [string]
        return [ anas[x] for x in anas ]

    #this one is also accepted but only beat 25% of python submissions
    def groupAnagrams(self, strs):
        dic = defaultdict(list)
        for string in strs:
            dic[''.join(sorted(string))] += [string]
        return [value for key, value in dic.items()]


