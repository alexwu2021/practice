import sys, unittest
abase = 48
class Solution(unittest.TestCase):
    #strings: a list of list of single digit integers
    def addNumberLists(self, strings, mxlength):
        height = len(strings)  
        ret = []
        for r in range(len(strings)):
            if len(strings[r]) < mxlength:
                strings[r] = [0] * (mxlength - len(strings[r])) + strings[r]
        
        carry = 0
        for i in range(mxlength-1, -1, -1):
            sm = 0
            for j in range(height):
                sm += strings[j][i]
            sm += carry
            rem = sm % 10
            carry = int(sm / 10)
            ret.append(rem)
        while carry > 0:
            rem = carry % 10
            ret.append(rem)
            carry = int(carry/ 10)
        return ''.join([chr(x + abase) for x in ret[::-1]])
            

    def multipleBySingleDigit(self, num, char, padding):
        ret = []
        carry = 0
        for i in range(len(num)-1, -1, -1):
            prod = (ord(char[0])-abase) * (ord(num[i])-abase)
            prod += carry
            rem = prod % 10
            carry = prod // 10
            ret.append(rem)

        while carry > 0:
            rem = carry % 10
            ret.append(rem)
            carry //= 10
        result = ret[::-1] + [0] * padding
        return result

    #accepted
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 is None or num2 is None:
            return -sys.maxsize
        if num1.rstrip().lstrip() == '0' or num2.rstrip().lstrip() == '0':
            return '0'
        
        size2 = len(num2)
        j = size2-1
        result = []
        mxlength = -sys.maxsize
        for j in range(size2-1, -1, -1):
            char2 = num2[j]
            ret = self.multipleBySingleDigit(num1, char2, size2-j-1)
            mxlength = max(mxlength, len(ret))
            result.append(ret)
        ret = self.addNumberLists(result, mxlength)
        return ret

    def test_multipleBySingleDigit(self):
        num = '1234'
        char = '3'
        ret = self.multipleBySingleDigit(num, char, 4)
        #print(ret)
        self.assertTrue(ret == [3, 7,0,2,0,0,0,0])
       

    def test_addNumberLists(self):
        strings = [[1, 9, 3], [1, 2, 3]]
        ret = self.addNumberLists(strings, 3)
        self.assertTrue(ret == '316')
        
    def test_multiply(self):
        num1 = '100940'
        num2 = '963'
        ret = self.multiply(num1, num2)
        print('test_multiply, result: %s' % ret)
        self.assertTrue(ret == '97205220')
   
    


if __name__ == '__main__':
    unittest.main()
