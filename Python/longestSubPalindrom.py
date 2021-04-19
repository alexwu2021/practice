import sys, unittest


class Solution(unittest.TestCase):
    low = sys.maxsize
    max_len = -sys.maxsize

    def extend_palindrome(self, s, right, left):
        size = len(s)
        while right >= 0 and left < size and s[right] == s[left]:
            right -= 1
            left += 1
        if self.max_len < left - right - 1:
            self.low = right + 1  # why this?
            self.max_len = left - right - 1

    def longest_palindrome_suboptimal(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) <= 1:
            return s
        for i in range(len(s)):
            self.extend_palindrome(s, i, i)
            self.extend_palindrome(s, i, i + 1)
        return s[self.low: self.low + self.max_len]

    def longest_palindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        ml = 1
        n = len(s)
        start = 0
        for i in range(0, n):
            for j in range(i, n):
                flag = True
                mid = (j - i + 1) // 2
                for k in range(0, mid):
                    if s[i + k] != s[j - k]:
                        flag = False
                        break
                if flag and j - i + 1 > ml:
                    start = i
                    ml = j - i + 1

        # start + ml is the end index
        return s[start: start + ml]

    def test_get_longest_sub_palindrom(self):
        s = 'accd'
        res = self.longest_palindrome(s)
        self.assertTrue(res == 'cc')

        s = 'tattarrattaty'
        res = self.longest_palindrome(s)
        self.assertTrue(res == 'tattarrattat')

        s = 'atattarrattatt'
        res = self.longest_palindrome(s)
        self.assertTrue(res == 'tattarrattat')

        s = 'forgeeksskeegfor'
        res = self.longest_palindrome(s)
        self.assertTrue(res == 'geeksskeeg')


if __name__ == '__main__':
    unittest.main()
