import unittest

import sys
class Solution(unittest.TestCase):
    #my bad, and the problem is the speed not taken care of well
    def longestWord_TLE_ming(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        mx = -sys.maxsize
        res = None
        for word in words:
            print('word: %s ' % word)
            size = len(word)
            temp = str(word)
            buildable = True
            while len(temp) > 0:
                temp = temp[:-1]
                print('temp: %s ' % temp)
                if temp != '' and temp not in words:
                    buildable = False
                    break
            if buildable and size > mx:
                mx = max(mx, size)
                res = word
        return res

    #the trick is sorting
    def longestWord(self, words):
        valids = {''}
        for word in sorted(words):
            if word[:-1] in valids:
                valids.add(word)
        return max(sorted(valids), key=len)
                
        

    def test_longestWord(self):
        words = ["w","wo","wor","worl", "world"]
        res = self.longestWord(words)
        print('res: %s ' % res)
        self.assertTrue(res == 'world')

        words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        res = self.longestWord(words)
        print('res: %s ' % res)
        self.assertTrue(res == 'apple') #not apply

if __name__ == '__main__':
    unittest.main()
