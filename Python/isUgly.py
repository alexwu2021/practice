class Solution:
    def isUgly(self, num): #1, 2, 3, 5 are ugly, but 4 is not, and 30 is 
        for p in 2, 3, 5:
            while (num % p == 0) and (num % p) < num:
                num /= p
        return num == 1