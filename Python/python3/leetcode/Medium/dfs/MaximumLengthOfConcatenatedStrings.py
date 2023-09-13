
 # 1239. Maximum Length of a Concatenated String with Unique Characters
import unittest

class MaximumLengthOfConcatenatedStrings:

    def maxLength(self, A):
        dp = [set()]
        for a in A:
            if len(set(a)) < len(a): continue
            a = set(a)
            for c in dp[:]:
                if a & c: continue
                dp.append(a | c)
        return max(len(a) for a in dp)



class TestMaximumLengthOfConcatenatedStrings(unittest.TestCase):
    sol = MaximumLengthOfConcatenatedStrings()


    def test_dupps_across_words(self):
        input = ["un", "iq", "ue"]
        actual = self.sol.maxLength(input)
        expected = 4
        self.assertEqual(expected, actual)

    def test_no_max_len_due_to_dups(self):
        input = ["aa", "bb"]
        actual = self.sol.maxLength(input)
        expected = 0
        self.assertEqual(expected, actual)

    def test_normal1(self):
        input = ["cha", "r", "act", "ers"]
        actual = self.sol.maxLength(input)
        expected = 6
        self.assertEqual(expected, actual)

    def test_normal2(self):
        input = ["a", "abc", "d", "de", "def"]
        actual = self.sol.maxLength(input)
        expected = 6
        self.assertEqual(expected, actual)

    def test_normala(self):
        input = ["a", "b"]
        actual = self.sol.maxLength(input)
        expected = 2
        self.assertEqual(expected, actual)

    def test_extreme(self):
        input = ["abcdefghijklmnopqrstuvwxyz"]
        actual = self.sol.maxLength(input)
        expected = 26
        self.assertEqual(expected, actual)


if __name__ == '__main__':
     unittest.main()


