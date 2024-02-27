import collections

# Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
#
# The line could be horizontal, vertical, diagonal, or anti-diagonal.


class LongestLines:
    def longestLine(self, M):
        maxlen = 0
        c = collections.Counter()
        for i, row in enumerate(M):
            for j, a in enumerate(row):
                for key in i, j + .1, i + j + .2, i - j + .3:  # rows, columns, diagonals and anti-diagonals
                    c[key] = (c[key] + 1) * a
                    maxlen = max(maxlen, c[key])
        return maxlen

mat = [[0, 1, 1, 0], [0, 1, 1, 0], [0, 0, 0, 1]]
actual = LongestLines().longestLine(mat)
expected = 3
assert(expected == actual)


mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
actual = LongestLines().longestLine(mat)
expected = 4
assert(expected == actual)
