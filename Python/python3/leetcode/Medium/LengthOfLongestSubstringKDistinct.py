import collections
import unittest

# 340
# Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

class LengthOfLongestSubstringKDistinct:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        n = len(s)
        if k >= n:
            return n
        left, right = k, n

        def isValid(size):
            counter = collections.Counter(s[:size])
            print("under checking: %s, size: %d" % (str(s[:size]), size))
            if len(counter) <= k:
                return True
            for i in range(size, n):
                counter[s[i]] += 1
                counter[s[i - size]] -= 1
                if counter[s[i - size]] == 0:
                    del counter[s[i - size]]
                if len(counter) <= k:
                    return True
            return False

        while left < right:
            mid = (left + right + 1) // 2  # to avoid possible infinite loop
            if isValid(mid):
                left = mid
            else:
                right = mid - 1
        return left


l = LengthOfLongestSubstringKDistinct()
source = "eceba"
k = 2
assert(l.lengthOfLongestSubstringKDistinct(source,k) == 3)

# source = "ecebbaaaa"
# k = 4
# assert(l.lengthOfLongestSubstringKDistinct(source,k) == 9)
