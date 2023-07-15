class Solution(object):
    #accepted
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo, hi = 1, n
        while lo < hi:
            mid = lo + (hi- lo) // 2
            res = isBadVersion(mid)
            if res:
                hi = mid  #hi can't be mid - 1
            else:
                lo = mid + 1
        return lo
    
    def firstBadVersion_borrowed(self, n):
        start, end = 1, n;
        while start < end:
            mid = start + (end-start) // 2;
            if not isBadVersion(mid):
                start = mid + 1;
            else:
                end = mid;             
        return start;
    