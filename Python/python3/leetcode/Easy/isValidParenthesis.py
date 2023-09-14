import os, sys, unittest

class Solution(unittest.TestCase):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        lefties = ['(', '{', '[' ]
        righties = [')', '}',  ']']
        stack = []
        i, size = 0, len(s)
        while i < size:
            ch = s[i]
            if ch not in lefties and ch not in righties:
                i += 1
                continue
            if ch in lefties:
                stack.append(ch)
                i += 1
                continue
            if ch in righties:
                if len(stack) != 0 and self.isAPair(stack[-1], ch):
                    i += 1
                    stack = stack[:-1]
                    continue
                else: 
                    return False
        
        if len(stack) == 0:
            return True
        return False
            
            
            
    def isAPair(self, char1, char2):
        if char1 == '(' and char2 == ')':
            return True
        if char1 == '[' and char2 == ']':
            return True
        if char1 == '{' and char2 == '}':
            return True
        return False
        
        
    def test_isValid(self):
        s = '()7afd{[]}'
        res = self.isValid(s)
        print ('res: %d' % res)
        self.assertTrue(res)


if __name__ == '__main__':
    unittest.main()
