import os, sys, unittest


class Solution(unittest.TestCase):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        st = set()
        for i in s:
            if i not in st:
                st.add(i)
        return ''.join(st)

    def test_lengthOfLongestSubstring(self):
        s = 'abcabcbb'
        res = self.lengthOfLongestSubstring(s)
        self.assertTrue(len(res) == 3)
        self.assertTrue(x in res for x in 'abc')

        s = 'bbbbbb'
        res = self.lengthOfLongestSubstring(s)
        self.assertTrue((x in res for x in 'b') and len(res) == 1)




if __name__ == '__main__':
    unittest.main()
