
import sys, unittest
from collections import Counter
 
class Solution(unittest.TestCase):
    def isNumber(self, s):
        print ('the soul of this program is this line currentState = state[currentState][c]')
        state = [{}, 
              {'blank': 1, 'sign': 2, 'digit':3, '.':4}, 
              {'digit':3, '.':4},
              {'digit':3, '.':5, 'e':6, 'blank':9},
              {'digit':5},
              {'digit':5, 'e':6, 'blank':9},
              {'sign':7, 'digit':8},
              {'digit':8},
              {'digit':8, 'blank':9},
              {'blank':9}] #nice, a list of dictionaries
        currentState = 1
        for c in s:
            if c >= '0' and c <= '9':
                c = 'digit'
            if c == ' ':
                c = 'blank'
            if c in ['+', '-']:
                c = 'sign'
            if c not in state[currentState].keys():
                return False
            currentState = state[currentState][c]
        if currentState not in [3,5,8,9]:
            return False
        return True


    def test_isNumber(self):
        s = "0"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)

        s = " 0.1 "
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)

        s = "abc"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertFalse(res)

        s = "1 a"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertFalse(res)

        s = "2e10"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)

        s = "e10"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertFalse(res)

        s = "2+"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertFalse(res)


        s = ".1"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)


        s = ".e"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertFalse(res)


        s = "46.e3"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)

        s = " 005047e+6"
        res = self.isNumber(s)
        print('res: %s for input: %s' % (res, s))
        self.assertTrue(res)

if __name__ == '__main__':
    unittest.main()
