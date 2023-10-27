
import unittest

from bisect import bisect_left, bisect_right
def find_range_of_target(nums, target):
    if not nums:
        return [-1, -1]
    left = bisect_left(nums, target)
    right = bisect_right(nums, target) -1

    if 0<=left<=right<<len(nums):
        return [left, right]
    return [-1, -1]

nums = [0, 1, 1, 1 , 2]
target = 1
actual = find_range_of_target(nums, target)
expected = [1, 3]
assert (expected == actual)

nums = [0, 1, 2]
target = 1
actual = find_range_of_target(nums, target)
expected = [1, 1]
assert (expected == actual)

nums = [0, 2, 3]
target = 1
actual = find_range_of_target(nums, target)
expected = [-1, -1]
assert (expected == actual)