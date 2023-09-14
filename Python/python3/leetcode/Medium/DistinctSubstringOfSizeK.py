# Input: s = "abcabc", k = 3
# Output: ["abc", "bca", "cab"]
# Example 2:
#
# Input: s = "abacab", k = 3
# Output: ["bac", "cab"]
# Example 3:
#

import unittest

class DistinctSubstringOfSizeK:
    def sub_string_k(self, s, k):
        if not s or k == 0:
            return []

        mp, res = {}, set()
        start = 0

        for i in range(len(s)):

            # adjust start if the current char has appeared in the current window
            if s[i] in mp and mp[s[i]] >= start:
                start = mp[s[i]] + 1

            mp[s[i]] = i
            if i - start + 1 == k:
                res.add(s[start:i + 1])
                start += 1

        return sorted(list(res))


class TestMaxTastiness(unittest.TestCase):
    sol = DistinctSubstringOfSizeK()

    def test_case1(self):
        s = "abcabc"
        k = 3
        expected = ["abc", "bca", "cab"]
        actual = self.sol.sub_string_k(s, k)
        self.assertEqual(expected, actual)


    def test_case2(self):
        s = "abacab"
        k = 3
        expected = ["bac",  "cab"]
        actual = self.sol.sub_string_k(s, k)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
