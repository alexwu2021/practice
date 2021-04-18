import sys, unittest, timeit


class Solution(unittest.TestCase):

    low = sys.maxsize
    max_len = -sys.maxsize

    def extend_palindrom(self, s, right, left):
        size = len(s)
        while right >= 0 and left < size and s[right] == s[left]:
            right -= 1
            left += 1
        if self.max_len < left - right - 1:
            self.low = right + 1  # why this?
            self.max_len = left - right - 1

    # this one accepted
    def longest_palindrome_suboptimal(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) <= 1:
            return s
        for i in range(len(s)):
            self.extend_palindrom(s, i, i)
            self.extend_palindrom(s, i, i + 1)
        return s[self.low:self.low + self.max_len]

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
                flag = 1
                mid = (j - i + 1)//2 + 1
                for k in range(0,  mid):
                    if s[i + k] != s[j - k]:
                        flag = 0
                if flag == 1 and j -i + 1 > ml:
                    start = i
                    ml = j-i + 1
        return s[start: start + ml]


    # def isPalin(self, s):
    #     size = len(s)
    #     mid = size // 2
    #     i = 0
    #     while i < mid:
    #         if s[i] != s[size - i - 1]:
    #             return False
    #         i += 1
    #     return True

    # def test_isPalin(self):
    #     # s = 'ababa'
    #     s = 'tattarrattat'
    #     res = self.isPalin(s)
    #     print('input: %s; res: %s' % (s, res))
    #     self.assertTrue(res)

    def test_get_longest_sub_palindrom(self):
        s = 'accd'
        res = self.longest_palindrome(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(res == 'cc')

        s = 'tattarrattaty'
        res = self.longest_palindrome(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == len(s) - 1)

        s = 'atattarrattatt'
        res = self.longest_palindrome(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == len(s) - 2)

        s = "forgeeksskeegfor"
        res = self.longest_palindrome(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(res == "geeksskeeg")




if __name__ == '__main__':
    unittest.main()
