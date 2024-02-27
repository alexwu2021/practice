# 488
import sys


# You are playing a variation of the game Zuma.
#
# In this variation of Zuma, there is a single row of colored balls on a board, where each ball can be colored red 'R', yellow 'Y', blue 'B', green 'G', or white 'W'. You also have several colored balls in your hand.
#
# Your goal is to clear all of the balls from the board. On each turn:
#
# Pick any ball from your hand and insert it in between two balls in the row or on either end of the row.
# If there is a group of three or more consecutive balls of the same color, remove the group of balls from the board.
# If this removal causes more groups of three or more of the same color to form, then continue removing each group until there are none left.
# If there are no more balls on the board, then you win the game.
# Repeat this process until you either win or do not have any more balls in your hand.
# Given a string board, representing the row of balls on the board, and a string hand, representing the balls in your hand, return the minimum number of balls you have to insert to clear all the balls from the board. If you cannot clear all the balls from the board using the balls in your hand, return -1.

class ZumaGame:

    def findMinStep(self, board, hand):
        def reduce_three_plus(brd): # 3 or 3+ consecutive chars will be reduced to a single char
            st = []
            n = len(brd)
            for i in range(n):
                ch = brd[i]
                st.append(ch)
                if (i == n - 1 or ch != brd[i + 1]) and len(st) >= 3:
                    a, b, c = st.pop(), st.pop(), st.pop()
                    if a == b == c:
                        while st and st[-1] == a:
                            st.pop()
                    else:
                        st.append(c)
                        st.append(b)
                        st.append(a)
            return ''.join(reversed(st))

        def dfs(brd, hd):
            key = brd + "_" + hd
            if key in d:
                return d[key]

            brd = reduce_three_plus(brd)
            ret, bsize, hsize = sys.maxsize, len(brd), len(hd)
            if bsize == 0 or hsize == 0:
                d[key] = 0 if bsize == 0 else sys.maxsize
                return 0 if bsize == 0 else sys.maxsize

            for i in range(hsize):
                for j in range(bsize):
                    if brd[j] == hd[i] or (j <= bsize - 2 and brd[j] == brd[j + 1]):
                        # run dfs on new board and new hand
                        ret = min(ret, 1 + dfs(brd[:j + 1] + hd[i] + brd[j + 1:], hd[:i] + hd[i + 1:]))

            d[key] = ret
            return ret
        
        d = {}
        ans = dfs(board, hand)
        return -1 if ans >= sys.maxsize else ans


board = "WRRBBW"
hand = "RB"
actual = ZumaGame().findMinStep(board, hand)
expected = -1
assert(expected == actual)

board = "WWRRBBWW"
hand = "WRBRW"
actual = ZumaGame().findMinStep(board, hand)
expected = 2
assert(expected == actual)


board = "G"
hand = "GGGGG"
actual = ZumaGame().findMinStep(board, hand)
expected = 2
assert(expected == actual)
