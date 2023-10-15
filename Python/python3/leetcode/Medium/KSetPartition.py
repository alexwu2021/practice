import unittest
from typing import List

class KSetPartition:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:

        total = sum(nums)
        if total % k:
            return False

        nums.sort(reverse=True)  # sorting as pruning

        sum_expected = total // k
        sub_sets = [0] * k

        def dfs(i):
            if i == len(nums):
                return True

            for j in range(k):
                if sub_sets[j] + nums[i] <= sum_expected:
                    sub_sets[j] += nums[i]

                    if dfs(i + 1):
                        return True

                    sub_sets[j] -= nums[i]
                    if sub_sets[j] == 0:  # another pruning
                        break
            return False

        return dfs(0)

assert (KSetPartition().canPartitionKSubsets(nums=[4,3,2,3,5,2,1], k=4))