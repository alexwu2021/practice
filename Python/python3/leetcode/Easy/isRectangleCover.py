
import unittest
import sys
#class Solution(object):
class Solution(unittest.TestCase):
   
    
    def processOneRectangle(self, st, r):
        lx, ly, rx, ry = r[0], r[1], r[2], r[3]
        for x in range(lx, rx):
            for y in range(ly, ry):
                lst = str(x) + '_' + str(y) + '_' + str(x + 1) + '_' + str(y + 1) 
                if lst not in st:
                    st.add(lst)
                
    #not accepted for time issue
    #maybe I should do area checking
    #and don't do the over covering checking
                    #need rewrite following the java code at the end
    def isRectangleCover(self, rectangles):
        """
        :type rectangles: List[List[int]]
        :rtype: bool
        """
        st = set()
        area = 0.0
        lxmin, lymin, rxmax, rymax = sys.maxsize, sys.maxsize, -sys.maxsize, -sys.maxsize
        for r in rectangles:
            lxmin, lymin, rxmax, rymax = min(lxmin, r[0]), min(lymin, r[1]), max(rxmax, r[2]), max(rymax, r[3])
            self.processOneRectangle(st, r)
            area += (r[2] - r[0]) * (r[3] - r[1])
        if area != (rxmax - lxmin) * (rymax - lymin):
            return False
        for x in range(lxmin, rxmax):
            for y in range(lymin, rymax):
                lst = str(x) + '_' + str(y) + '_' + str(x + 1) + '_' + str(y + 1) 
                if lst not in st:
                    return False
        return True

    def isRectangleCover_alsoBad(self, rectangles):
        def recordCorner(point):
            if point in corners:
                corners[point] += 1
            else:
                corners[point] = 1

        corners = {}                                # record all corners 
        L, B, R, T, area = float('inf'), float('inf'), -float('inf'), -float('inf'), 0

        for sub in rectangles:
            L, B, R, T = min(L, sub[0]), min(B, sub[1]), max(R, sub[2]), max(T, sub[3])
            ax, ay, bx, by = sub[:]
            area += (bx-ax)*(by-ay)                 # sum up the area of each sub-rectangle
            map(recordCorner, [(ax, ay), (bx, by), (ax, by), (bx, ay)])

        if area != (T-B)*(R-L): return False        # check the area

        big_four = [(L,B),(R,T),(L,T),(R,B)]

        for bf in big_four:                         # check corners of big rectangle
            if bf not in corners or corners[bf] != 1:
                return False

        for key in corners:                         # check existing "inner" points
            if corners[key]%2 and key not in big_four:
                return False

        return True

    def test_isRectangleCover(self):
        rectangles =[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
        res = self.isRectangleCover(rectangles)
        self.assertTrue(res)
        rectangles = [[0,0,4,1],[7,0,8,2],[6,2,8,3],[5,1,6,3],[4,0,5,1],[6,0,7,2],[4,2,5,3],[2,1,4,3],[0,1,2,2],[0,2,2,3],[4,1,5,2],[5,0,6,1]]
        res = self.isRectangleCover(rectangles)
        self.assertTrue(res)

if __name__ == '__main__':
    unittest.main()
