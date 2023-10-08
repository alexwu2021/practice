import unittest

# 1249

# Given a string s of '(' , ')' and lowercase English characters.
#
# Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
# so that the resulting parentheses string is valid and return any valid string.
#
# Formally, a parentheses string is valid if and only if:
#
# It is the empty string, contains only lowercase characters, or
# It can be written as AB (A concatenated with B), where A and B are valid strings, or
# It can be written as (A), where A is a valid string.

class MinRemoveToMakeValid:



    def minRemoveToMakeValid(self, source: str) -> str:
        remover = set()
        stack = []
        for i, c in enumerate(source):
            if c not in "()":
                continue
            if c == "(":
                stack.append(i)
                continue

            # c == ')'
            if not stack:
                remover.add(i)
            else:
                stack.pop()

        remover = remover.union(set(stack))

        string_builder = []
        for i, c in enumerate(source):
            if i not in remover:
                string_builder.append(c)
        return "".join(string_builder)



    # one pass
    def minRemoveToMakeValid_better(self, source: str) -> str:
        s = list(source)
        stack = []
        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            elif char == ')':
                if stack:
                    stack.pop()
                else:
                    s[i] = ''  # the unmatched has to be killed, otherwise, the resulting string won't be valid
        while stack:
            s[stack.pop()] = ''
        return ''.join(s)


class Test(unittest.TestCase):
    sol = MinRemoveToMakeValid()

    def test_case1(self):
        s = "lee(t(c)o)de)"
        expected = "lee(t(c)o)de"
        # Explanation: "lee(t(co)de)", "lee(t(c)ode)"
        actual = self.sol.minRemoveToMakeValid(s)
        self.assertEqual(expected, actual)

    def test_case2(self):
        s = "a)b(c)d"
        expected = "ab(c)d"
        actual = self.sol.minRemoveToMakeValid(s)
        self.assertEqual(expected, actual)

    def test_case3(self):
        s = "))(("
        expected = ""
        actual = self.sol.minRemoveToMakeValid(s)
        self.assertEqual(expected, actual)

    def test_case4(self):
        s = "))("
        expected = ""
        actual = self.sol.minRemoveToMakeValid(s)
        self.assertEqual(expected, actual)

    def test_case5(self):
        s = ")()("
        expected = "()"
        actual = self.sol.minRemoveToMakeValid(s)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
