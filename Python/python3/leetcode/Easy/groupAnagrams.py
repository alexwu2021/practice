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



