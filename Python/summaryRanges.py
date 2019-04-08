import sys, unittest

class Solution(unittest.TestCase):
    #this is my way, straightforward but accepted
    def summaryRanges_mine(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        lst = []
        if not nums:
            return lst
        n = len(nums)
        if n == 0:
            return lst
        if n == 1:
            lst.append(str(nums[0]))
            return lst
        
        i = 0
        while i < n:
            i += 1
            if n > i > 0 and nums[i] - nums[i-1] > 1:
                lst.append(str(nums[i-1]))
                continue
            
            #nums[i] == nums[i-1] + 1
            start, j = i -1, i
            while(j<n and nums[j] - nums[j-1] == 1):
                j += 1
            if j-1 > start:
                lst.append(str(nums[start]) + "->" + str(nums[j-1]))
            else:
                lst.append(str(nums[start]))
            i = j
        return lst

    #it is valid solution, but not necessary faster than my plain one
    def summaryRanges(self, nums):
        ranges, r = [], []
        for n in nums:
            if n-1 not in r:
                r = []
            ranges += r,
            r[1:] = n,
        print('for ranges: %s; r: %s' % (ranges, r))
        return ['->'.join(map(str, r)) for r in ranges]

    def test_summaryRanges(self):
        nums = [0, 2, 3, 4, 7, 8, 10]
        nums = [4, 5, 6, 7, 9]
        res = self.summaryRanges(nums)
        print('for nums: %s; res: %s' % (nums, res))

        



if __name__ == '__main__':
    unittest.main()
