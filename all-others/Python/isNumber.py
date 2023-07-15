
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
    
    #not pass, but this is my best effort. it got stuck in the test case 46.e3, which I think is invalid number but leetcode thinks it is.
    #as is, it can not handle the case like " 005047e+6", which I don't care now
    def isNumber_mine(self, s):
        """
        :type s: str
        :rtype: bool
        """
        class descriptor(object):
            def __init__(self, char, index, nPreviousChar, nAfterChar):
                self.char = char
                self.index = index
                self.nPreviousChar = nPreviousChar
                self.nAfterChar = nAfterChar
            def __repr__(self):
                msg = 'char: %s; index: %d; previus char: %s; after char: %s' % (self.char, self.index, chr(self.nPreviousChar) if self.nPreviousChar >0 else '[empty]', chr(self.nAfterChar) if self.nAfterChar >0 else '[empty]')
                return msg
            
        if s is None or len(s) == 0: return False
        s = s.lstrip()
        s = s.rstrip()
        if len(s) == 0: return False
        
        positiveCount, negativeCount = sum(1 for c in s if c == '+'), sum(1 for c in s if c == '-')
        if positiveCount > 1 or  negativeCount > 1: return False
        
        if positiveCount == 1:
            if s[0] != '+': return False
            else:
                if sum(1 for c in s if c == ' ') > 0:
                    return False
                s = s[1:]
        if negativeCount == 1:
            if s[0] != '-': return False
            else:
                if sum(1 for c in s if c == ' ') > 0:
                    return False
                s = s[1:]
        
        
        validDigits = [x for x in '0123456789']
        monitors = ['.', ',', 'e']
        rejects = [chr(x) for x in range(1, 129) if chr(x) not in (monitors + validDigits) ]
        counter = Counter()
        descriptors = []
        size = len(s)
        if size == 1 and s[0] in monitors:
            return False
        
        for i in range(len(s)):
            ch = s[i]
            if ch in rejects:
                return False
            if ch in monitors:
                counter[ch] += 1
                prev, after = ord(s[i -1]) if i >= 1 else -sys.maxsize, ord(s[i + 1]) if i <= size -2 else -sys.maxsize
                desc = descriptor(ch, i, prev, after)
                descriptors.append(desc)
                
        for c in counter:
            if counter[c] > 1 and c != ',':
                return False
            
        for desc in descriptors:
            if desc.char in ('e') and (desc.index == 0 or desc.nAfterChar == -sys.maxsize or (desc.nAfterChar != -sys.maxsize and chr(desc.nAfterChar) not in validDigits)):
                return False
            if desc.char in ('.') and ((desc.nPreviousChar != -sys.maxsize and chr(desc.nPreviousChar) not in validDigits) or (desc.nAfterChar != -sys.maxsize and chr(desc.nAfterChar) not in validDigits)):
                #print('to return false for s %s' % s)
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
