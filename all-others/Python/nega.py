import unittest


class TestStringMethods(unittest.TestCase):
    def test_isvalid_good(self):
        s = 'abab'
        p = ['a', 'b']
        res = self.isvalid(s, p)
        self.assertTrue(res)
    def test_isvalid_bad(self):
        s = 'aababbabb'
        p = ['a', 'b']
        res = self.isvalid(s, p)
        self.assertFalse(res)
       
    def isvalid(self, s, p):
        lst =[]
        lst.append(s[0])
        for i in range(1,len(s)):
                if len(lst) > 0 and lst[-1] == p[0] and s[i] == p[1]:
                        lst = lst[:-1]
                else:
                        lst.append(s[i])
        return True if len(lst) == 0 else False



if __name__ == '__main__':
    unittest.main()
