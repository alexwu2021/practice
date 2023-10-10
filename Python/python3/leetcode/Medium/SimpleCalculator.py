import re
import unittest
import re
class SimpleCalculator:
    def calculate(self, s: str) -> int:
        stack = []
        sign = '+'
        i = 0
        while i < len(s):
            c = s[i]
            if c.isdigit():
                n = 0
                while i < len(s) and s[i].isdigit():
                    n = n * 10 + (ord(s[i]) - ord('0'))
                    i += 1

                if sign == '+':
                    stack.append(n)
                elif sign == '-':
                    stack.append(-n)
                elif sign == '*':
                    stack.append(stack.pop() * n)
                else:
                    front = stack.pop()
                    if front < 0:
                        stack.append(-(-front // n))
                    else:
                        stack.append(front // n)
            elif c.isspace():
                i += 1
            else:
                sign = c
                i += 1

        return sum(stack)




class TestSimpleCalculator(unittest.TestCase):
    sol = SimpleCalculator()
    def test1(self):
        s = "3+2*2"
        actual = self.sol.calculate(s)
        expected = 7
        self.assertEqual(expected, actual)

    def test2(self):
        s = "3/2"
        actual = self.sol.calculate(s)
        expected = 1
        self.assertEqual(expected, actual)

    def test3(self):
        s = " 3+5 / 2 "
        actual = self.sol.calculate(s)
        expected = 5
        self.assertEqual(expected, actual)


    def test4(self):
        s = " 42 "
        actual = self.sol.calculate(s)
        expected = 42
        self.assertEqual(expected, actual)

    def test5(self):
        s = " 625 /25  * 1"
        actual = self.sol.calculate(s)
        expected = 25
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()
