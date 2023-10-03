import sys, unittest
import operator

class Solution(unittest.TestCase):
    
    
    #invalid, need more works.
    #should improve dp backtracking skills
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        pairlist = []
        size = len(s)
        dp = [-sys.maxsize] * (size + 1)
        dp[size] = 1
        for i in range(size-1, -1, -1):
            if i == size -1:
                dp[i] = dp[i + 1]
            for j in range(i+ 1, size, 1):
                if self.isPalin(s[i:j + 1]):
                    print('s[i:j]: %s is palin' % (s[i:j]))
                    pairlist.append((i, j))
                    dp[j] = max(dp[j], dp[j+1] + 1)
                else:
                    dp[j] = max(dp[j], dp[j+1])

        res = []
        defaultPartition = [ str(x) for x in s]
        res.append(defaultPartition)
        print("pairlist: %s" % pairlist)
        ret = self.subsets(pairlist)
        print("ret: %s" % ret)
        for r in ret:
            if len(r) <= 0: continue
            newPartition = self.generateOnePartition(s, r)
            print("newPartition: %s" % newPartition)
            if newPartition is not None and newPartition not in res:
                res.append(newPartition)
        return res
            
    def isPalin(self, s):
        size = len(s)
        mid = size // 2
        i = 0
        while i < mid:
            if s[i] != s[size -i -1]:
                return False
            i += 1
        return True
    
    def getNumberOfWaysOfPartition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        size = len(s)
        dp = [-sys.maxsize] * (size + 1)
        dp[size] = 1
        for i in range(size-1, -1, -1):
            if i == size -1:
                dp[i] = dp[i + 1]
            for j in range(i+ 1, size, 1):
                if self.isPalin(s[i:j]):
                    print('s[i:j]: %s is palin' % (s[i:j]))
                    dp[j] = max(dp[j], dp[j+1] + 1)
                else:
                    print('s[i:j]: %s is not palin' % (s[i:j]))
                    dp[j] = max(dp[j], dp[j+1])
        return dp[size -1]

    def subsets(self, plist):
        size = len(plist)
        jspace = pow(2, size)
        res = []
        for i in range(jspace):
            res.append([])
        for i in range(size):
            for j in range(jspace):
                if (j >> i ) & 1:
                    res[j].append(plist[i])
        return res
        
    def generateOnePartition(self, base, pairlist):
        #suppose no overlapping
        pairlist.sort(key=operator.itemgetter(0))

        i, overlapping = 0, False
        while i <= len(pairlist) -2:
            if pairlist[i][1] > pairlist[i + 1][0]:
                overlapping = True
            i += 1
        if overlapping:
            return None

        print('not overlapping')
        res = []
        i, size = 0, len(base)
        for p in pairlist:
            start, end = p[0], p[1]
            if start > i:
                res.append(base[0:start])
            res.append(base[start:end + 1])
            i = end + 1
        if i < size:
            res.append(base[i:size])
        return res
            
                     

    def test_getNumberOfWaysOfPartition(self):
        s = 'aabab'
        res = self.getNumberOfWaysOfPartition(s)
        self.assertTrue(res == 5)
        pass

    def test_partition(self):
        s = 'aab'
        res = self.partition(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == 2)

        s = 'aabab'
        res = self.partition(s)
        print('input: %s; res: %s' % (s, res))
        self.assertTrue(len(res) == 4)



if __name__ == '__main__':
    unittest.main()


