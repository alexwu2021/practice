import unittest

class FaultyKeyBoard:

    # there exists swap based O(N) solution
    def finalString(self, s: str) -> str:
        if not s or (len(s) == 1 and s[0] == 'i'):
            return s

        i = 0
        stack = []
        while i < len(s) and s[i] != 'i':
            stack.append(s[i])
            i += 1

        if i == len(s):
            return "".join(stack)
        else:
            prefix = "".join(stack[::-1])
            return self.finalString(prefix + s[i + 1:])



class TestFaultyKeyBoard(unittest.TestCase):
    sol = FaultyKeyBoard()

    def test_case1(self):
        input = "poiinter"
        expected = "ponter"
        actual = self.sol.finalString(input)
        self.assertEqual(expected, actual)




if __name__ == '__main__':
    unittest.main()


