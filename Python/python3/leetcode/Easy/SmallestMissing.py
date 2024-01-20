import bisect
from itertools import pairwise
from typing import List
import sys
class SmallestMissing:
    # this is wrong because the assumption is to find the missing item equal or 1 bigger than the sum of longest prefix sub array
    # def missingInteger(self, nums: List[int]) -> int:
    #     st = set(nums)
    #     n = len(nums)
    #     max_len = 1
    #     msm = nums[0]
    #     start, sm = 0, 0
    #     for i, v in enumerate(nums):
    #         if v - nums[i - 1] == 1:
    #             sm += nums[i]
    #         else:
    #             start = i
    #             sm = nums[i]
    #         if i - start + 1 > max_len:
    #             max_len = i - start + 1
    #             msm = max(msm, sm)
    #     if msm not in st:
    #         return msm
    #     nums.sort()
    #     for i in range(n):
    #         if nums[i] == msm:
    #             msm += 1
    #         elif nums[i] > msm:
    #             return msm
    #     return msm

    def missingInteger(self, nums: List[int]) -> int:
        ans = nums[0]
        for n1, n2 in pairwise(nums):
            if n2 - n1 == 1:
                ans += n2
            else:
                break
        while ans in nums:
            ans += 1
        return ans


#
# nums = [14,9,6,9,7,9,10,4,9,9,4,4]
# actual = SmallestMissing().missingInteger(nums)
# assert(actual == 15)
#
#
# nums = [38]
# actual = SmallestMissing().missingInteger(nums)
# assert(actual == 39)
#
#
# nums = [3,4,5,1,12,14,13]
# actual = SmallestMissing().missingInteger(nums)
# assert(actual == 15)


nums = [4,5,6,7,8,8,9,4,3,2,7, 31, 32, 33, 34, 35, 36, 37, 38]
actual = SmallestMissing().missingInteger(nums)
print(actual)
assert(actual == 32)