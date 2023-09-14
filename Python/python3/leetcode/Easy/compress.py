import unittest
from functools import reduce
class Solution(unittest.TestCase):

    #accepted
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        totalIndex, index, n = 0, 0, len(chars)
        while index < n:
            currChar = chars[index]
            count = 0
            while index < n and chars[index] == currChar:
                count += 1
                index += 1
            chars[totalIndex] = currChar
            totalIndex += 1  #this could be the part I will miss
            if count != 1:
                for c in str(count):
                    chars[totalIndex] = c
                    totalIndex +=1
        chars[:] = chars[:totalIndex]  #slice assignment. A slice of [:] means the entire list. forced to change the content
        return len(chars)

    #something wrong, not easy to explain
    def compress(self, c):
        """
        :type chars: List[str]
        :rtype: int
        """
        flips = [(c[0], 0)] + [(c[i], i) for i in range(1, len(c)) if c[i] != c[i - 1]] + [(None, len(c))]
        print('flips: %s; flips[1:]: %s; zip(flips[1:], flips): %s' % (flips, flips[1:], list(zip(flips[1:], flips))))
        chunks = [(b[0], a[1] - b[1]) for (a, b) in zip(flips[1:], flips)]
        print('chunks: %s' % chunks)
        compressed = ''.join(a + str(b) if b > 1 else a for a, b in chunks)
        print('compressed: %s' % compressed)
        return len(compressed)

    def test_compress(self):
        chars = ["a","a","b","b","c","c","c"]
        res = self.compress(chars)
        print('for input: %s; res:%d' % (chars, res))
        



if __name__ == '__main__':
    unittest.main()
