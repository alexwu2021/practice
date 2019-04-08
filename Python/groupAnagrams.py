import unittest

from collections import defaultdict

class Solution(unittest.TestCase):
    #this one is accepted
     def groupAnagrams(self, strs):
        anas = {}
        for string in strs:
            s = ''.join(sorted(string))
            if s in anas:
                anas[s].append(string)
            else:
                anas[s] = [string]
        return [ anas[x] for x in anas ]

    #this one is also accepted but only beat 25% of python submissions
    def groupAnagrams(self, strs):
        dic = defaultdict(list)
        for string in strs:
            dic[''.join(sorted(string))] += [string]
        return [value for key, value in dic.items()]



   

    #time issue
    def groupAnagrams(self, strs):
        mp = {}
        for s in strs:
            t = self.myStringSort(s)
            if t not in mp.keys():
                mp[t] = []
            mp[t].append(s)
        res = []
        for ky in mp:
            res.append(mp[ky])
        return res
    
    def myStringSort(self, s):
        c = [0] * 26
        for ch in s:
            c[ord(ch) - 97] += 1
        res = ''
        for i in range(26):
            for j in range(c[i]):
                res += str(chr(i + 97))
        return res





    def isAnagram(self, s1, s2):
        return sorted(s1) == sorted(s2)

    
    
    
    def processOneGroup(self, strings):
        ret = []
        while len(strings) >= 1:
            temp = [strings[0]]
            strings = strings[1:]
           
            indices = []
            for i in range(len(strings)):
                if self.isAnagram(temp[0], strings[i]):
                    temp.append(strings[i])
                    indices.append(i)
                    
            j = len(indices) -1
            while j >= 0:
                del strings[indices[j]]
                j -= 1
                
            ret.append(temp)
        return ret
    
    def groupAnagrams_tooMuchTime(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = []
        lenToStrings = {}
        for s in strs:
            ln = len(s)
            if ln not in lenToStrings:
                lenToStrings[ln] = []
            lenToStrings[ln].append(s)
    
        for key in lenToStrings:
            if len(lenToStrings[key]) > 0:
                ret = self.processOneGroup(lenToStrings[key])
                lenToStrings[key] = []
                for r in ret:
                    res.append(r)
        return res


    def test_myStringSort(self):
        s = 'mybestfunction'
        res = self.myStringSort(s)
        print ('test_myStringSort. s: %s; res: %s' % (s, res))

    def test_isAnagram(self):
        s1, s2 = 'apple', 'aplep'
        s1, s2 = ' ', ' '
        res = self.isAnagram(s1, s2)
        self.assertTrue(res)
        

    def test_groupAnagrams(self):
        strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        res = self.groupAnagrams(strs)
        print('res: %s' % (res))
        self.assertTrue(len(res) == 3)

        for r in res:
            if len(r) == 1:
                self.assertTrue(r[0] == 'bat')
            elif len(r) == 2:
                self.assertTrue('nat' in r and 'tan' in r)
            elif len(r) == 3:
                self.assertTrue('ate' in r and 'eat' in r and 'tea' in r)

    def test_groupAnagrams_cornerCase(self):
        strs = ["","",""]
        res = self.groupAnagrams(strs)
        print('res: %s' % (res))
        self.assertTrue(len(res) == 1 and len(res[0]) == 3 and len(res[0][0]) == 0)  #expecting [["","",""]]




if __name__ == '__main__':
    unittest.main()

