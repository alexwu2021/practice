import sys
class Solution(object):
    #accepted, solved using match, seems no-dp
    def integerBreak(self, n):
        if n < 3:
            return 1
        if n == 3:
            return 2
        if n % 3 == 0:
            return pow(3, n // 3)
        if n % 3 == 1:
            return 2 * 2 * pow(3, (n - 4) // 3) #the subtraction of 4 is compensated with 4 *
        return 2 * pow(3, (n - 2) // 3) #the substraction of 2 is compensated with 2 *
    
