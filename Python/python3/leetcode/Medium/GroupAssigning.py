from math import ceil
from typing import List
from collections import defaultdict
import sys


# 2910

class GroupAssigning:
    def minGroupsForValidAssignment(self, nums):
        def partition(guess, frequencies):
            result = 0
            for f in frequencies:
                num_groups, remainder = divmod(f, guess)
                if remainder > num_groups:
                    return float("inf")
                result += ceil(f / (guess + 1))
            return result

        counts = defaultdict(int)
        for num in nums:
            counts[num] += 1
        frequencies = counts.values()
        if len(frequencies) == 1:
            return 1
        result = len(nums)
        least_frequent = min(frequencies)
        for partition_size in range(1, least_frequent + 1):
            result = min(result, partition(partition_size, frequencies))
        return int(result)


input = [1, 1, 3, 3, 1, 1, 2, 2, 3, 1, 3, 2]
actual = GroupAssigning().minGroupsForValidAssignment(input)
assert (5 == actual)

input = [3, 3, 3, 3, 3, 1, 1]
actual = GroupAssigning().minGroupsForValidAssignment(input)
assert (actual == 3)

input = [10, 10, 10, 3, 1, 1]
actual = GroupAssigning().minGroupsForValidAssignment(input)
assert (actual == 4)
