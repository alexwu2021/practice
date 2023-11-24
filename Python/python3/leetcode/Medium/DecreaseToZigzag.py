class DecreaseToZigzag:
    def movesToMakeZigzag(self, nums):
        nums = [float('inf')] + nums + [float('inf')]
        n = len(nums)
        evens = sum(max(0, nums[i] - min(nums[i - 1], nums[i + 1]) + 1) for i in range(1, n - 1, 2))
        odds = sum(max(0, nums[i] - min(nums[i - 1], nums[i + 1]) + 1) for i in range(2, n - 1, 2))
        return min(evens, odds)

nums = [10,4,4,10,10,6,2,3]
actual = DecreaseToZigzag().movesToMakeZigzag(nums)
print("actual: %s" % actual)
assert(12 == actual)