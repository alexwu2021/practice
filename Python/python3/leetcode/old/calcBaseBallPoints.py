import sys
import unittest

class Solution(unittest.TestCase):
    #this one accepted
    def calcBaseBallPoints(self, ops):
        if ops is None or len(ops) <= 0 \
           or ops[0] in ('C', 'D', '+'):
            return -sys.maxsize
        
        lst = []
        for op in ops:
            if str(op) != 'C':
                lst.append(op)
            else:
                lst = lst[:-1]
        
        for i in range (len(lst)) :
            if str(lst[i]) == 'D' and i >= 1:
               lst[i] = int(lst[i-1]) * 2
            elif str(lst[i]) == '+' and i >= 2:
               lst[i] = int(lst[i-1])  +  int(lst[i-2])
        return sum(int(x) for x in lst)

    def test_calcBaseBallPoints(self):
        ops = ["5","-2","4","C","D","9","+","+"]
        res = self.calcBaseBallPoints(ops)
        self.assertTrue(res == 27)

        ops = ["5","2","C","D","+"]
        res = self.calcBaseBallPoints(ops)
        self.assertTrue(res == 30)

        ops = ["61","-50","65","+","D","-99","-58","88","19","-11"]
        res = self.calcBaseBallPoints(ops)
        self.assertTrue(res == 60)

if __name__ == '__main__':
    unittest.main()
    
