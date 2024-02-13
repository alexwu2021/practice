# Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.
#
# An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
#
# A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
#
# For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
#
#
# Example 1:
#
# Input: strs = ["aba","cdc","eae"]
# Output: 3
# Example 2:
#
# Input: strs = ["aaa","aaa","aa"]
# Output: -1
#

class LongestUncommonSubsequence2:
    def findLUSlength(self, strs) -> int:
        def is_sub(w1, w2):  # is every char in w1 existing in w2?
            if len(w1) > len(w2):
                return False

            i = 0
            for ch in w2:
                if i < len(w1) and w1[i] == ch:
                    i += 1
            return i == len(w1)

        strs.sort(key=len, reverse=True) # the sorting ensure we can return at the first time we find one candidate
        for i, ss in enumerate(strs):
            lst = [not is_sub(ss, strs[j]) for j in range(len(strs)) if
                   j != i]  # eval results, a list of booleans, of size len(strs) -1
            if all(lst): # due to sorting, we can return
                return len(ss)
        return -1

