import unittest


class Solution(unittest.TestCase):
    #accepted, explainanle
    def nextGreaterElements(self, nums):
        stack, res = [], [-1 for i in range(len(nums))]
        for i in range(len(nums)):
            while stack and (nums[stack[-1]] < nums[i]):
                res[stack.pop()] = nums[i]
            stack.append(i)
        if stack:
            for i in range(stack[0] + 1):
                while nums[stack[-1]] < nums[i]:
                    res[stack.pop()] = nums[i]
        return res

    def test_nextGreaterElements(self):
        nums = [1,2,1]
        res = self.nextGreaterElements(nums)
        self.assertTrue(res == [2,-1,2])



if __name__ == '__main__':
    unittest.main()
