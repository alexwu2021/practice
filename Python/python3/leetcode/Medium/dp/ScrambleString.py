from functools import cache
# 87. Scramble String
# We can scramble a string s to get a string t using the following algorithm:
#
# If the length of the string is 1, stop.
# If the length of the string is > 1, do the following:
# Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
# Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
# Apply step 1 recursively on each of the two substrings x and y.
# Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
class ScrambleString:

    def isScramble(self, s1: str, s2: str) -> bool:
        @cache
        def dp(a: str, b: str) -> bool:
            if a == b: return True
            if sorted(a) != sorted(b): return False

            for i in range(1, len(a)):
                # after split, left vs. left, right vs. right
                if dp(a[:i], b[:i]) and dp(a[i:], b[i:]): return True

                # after split, left vs right, right vs left
                if dp(a[i:], b[:-i]) and dp(a[:i], b[-i:]): return True
            return False

        return dp(s1, s2)
