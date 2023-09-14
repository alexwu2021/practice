


def twoSum(nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        s = {}
        size = len(nums)
        for i in range(size):
            s[nums[i]] = i
        for i in range(size):
            diff = target-nums[i]
            if diff in s and i != s[diff]:
                return [i, s[diff]]
        return [-1, -1]
        

nums = [2, 3, 7, 11, 4, 4, 66]
target = 6
res = twoSum(nums, target)
print (res)

