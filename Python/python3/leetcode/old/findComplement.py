class Solution(object):

    #the whole idea is to come out with a all-ones integer that is matching, and do the xor
    def findComplement(self, num):
        i = 1
        while i <= num:  #pay attention to the equal sign, most important
            i = i << 1
        print('i: %s' % i)
        return (i - 1) ^ num


s = Solution()
n = 5
res = s.findComplement(n)
print('res: %s' % res)
