import unittest

class Solution(unittest.TestCase):

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
