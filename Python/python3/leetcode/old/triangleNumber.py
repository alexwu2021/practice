
import unittest
from collections import Counter
from random import randint
class Solution(unittest.TestCase):
    #accepted
    def triangleNumber(self, nums):
        A = sorted(nums)
        count, n = 0, len(nums)
        for i in range(n-1, 1, -1):
            left, right = 0, i-1
            while left < right:
                if A[left] + A[right] > A[i]:
                    count += right - left
                    right -= 1
                else:
                    left += 1
        return count
    
    #my way, tle
    def triangleNumber_tle(self, nums2):
        """
        :type nums: List[int]
        :rtype: int
        """
        def isTriangleable(tpl):
            a, b, c = tpl[0], tpl[1], tpl[2]
            if a + b <= c or a + c <= b or b + c <= a:
                return False
            return True
        def getTuple(a, b, c):
            lst = sorted([a, b, c])
            return (lst[0], lst[1], lst[2])

        nums = sorted(nums2)
        n = len(nums)    
        d = Counter()
        for i in range(n-2):
            j, k = i+1, n-1
            while j < k:
                t = getTuple(nums[i], nums[j], nums[k])
                testNumber = 1
                if isTriangleable(t):
                    d[t] += 1
                if testNumber == 1:
                    j += 1
                    testNumber -= 1
                else:
                    k -= 1
                    testNumber += 1
                    
        print('d: %s' % d)
        return sum([x for x in d.values()])

    def test_triangleNumber(self):
        lst = [2, 2, 3, 4]
        res = self.triangleNumber(lst)
        print('for input: %s, res: %d' % (lst, res))
        self.assertTrue(res == 3)

if __name__ == '__main__':
    unittest.main()
