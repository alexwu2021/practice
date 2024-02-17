from collections import defaultdict
from typing import List


class LargestDivisibleSubset:


    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        num2sets = defaultdict(set)
        nums.sort()
        for num in nums:
            divisors = [key for key in num2sets if num % key == 0]
            candidates = [num2sets[d] for d in divisors]
            if not candidates:
                num2sets[num] = {num}
            else:
                num2sets[num] = max(candidates, key=len) | {num}
        return max(num2sets.values(), key=len)

    def largestDivisibleSubset_2(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        groupSize = [1] * n
        prevElement = [-1] * n
        maxIndex = 0

        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    if groupSize[i] < 1 + groupSize[j]:
                        groupSize[i] = 1 + groupSize[j]
                        prevElement[i] = j
            if groupSize[i] > groupSize[maxIndex]:
                maxIndex = i

        ans = []
        while maxIndex != -1:
            ans.insert(0, nums[maxIndex])
            maxIndex = prevElement[maxIndex]

        return ans


nums = [1,2,3]
actual = LargestDivisibleSubset().largestDivisibleSubset(nums)
print(actual)
assert(actual == {1, 2})

nums = [3,4,16,8]
actual = LargestDivisibleSubset().largestDivisibleSubset(nums)
print(actual)
assert(actual == {4, 8, 16})
