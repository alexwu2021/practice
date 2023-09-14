
from collections import OrderedDict
class Solution(object):
    #this one accepted
    def frequencySort_accepted(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or len(s) == 1:
           return s
        d = {}
        for x in s:
            if x in d:
                newPair = (d[x][0] + 1, x)
                d[x] = newPair
            else:
                d[x] = (1, x)
        
        items = list(d.items())
        items.sort(key = lambda x: x[1], reverse=True)
        ret = ''
        for item in items:
            for j in range(item[1][0]):
                ret += item[0]
        return ret


    #this one is aparently better, but I didn't submittted
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or len(s) == 1:
           return s
        d = {}
        for x in s:
            if x in d:
                newPair = (d[x][0] + 1, x)
                d[x] = newPair
            else:
                d[x] = (1, x)
        values = list(d.values())  #using values is more readable here, logic is more apparent
        values.sort(key = lambda x: x[0], reverse=True)
        ret = ''
        for val in values:
            for j in range(val[0]):
                ret += val[1]
        return ret

    #this one needs more work, right now its not working
    def frequencySort_using_od(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or len(s) == 1:
           return s
        d = OrderedDict()
        for x in s:
            if x in d:
                newPair = (d[x][0] + 1, x)
                d[x] = newPair
            else:
                d[x] = (1, x)
        
        ret = ''
        for key in  reversed(d):
            for j in range(d[key][0]):
                ret += d[key][1]
        return ret
print('beginning')
sol = Solution()
s = 'deareeeeeeaa'
ret = sol.frequencySort(s)
print('source: %s; result: %s' % (s, ret))
