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
    def nextGreaterElements_notworking(self, nums):
        stack, r = [], [-1] * len(nums)
        for i in range(len(nums)):
            while stack and (nums[stack[-1]] < nums[i]):
                r[stack.pop()] = nums[i]
                stack.append(i)
        for i in range(len(nums)):
            while stack and (nums[stack[-1]] < nums[i]):
                r[stack.pop()] = nums[i]
            if stack == []:
                break
        return r
    
    #tle issue in leetcode
    def nextGreaterElements_tle(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ret = []
        for i in range(len(nums)):
            num = nums[i]
            j = (i + 1) % len(nums)
            found = False
            while j != i:
                if nums[j] > num:
                    ret.append(nums[j])
                    found = True
                    break
                j = (j +  1) % len(nums)
            if not found:
                ret.append(-1)
        return ret
        
    def test_nextGreaterElements(self):
        nums = [1,2,1]
        res = self.nextGreaterElements(nums)
        self.assertTrue(res == [2,-1,2])



if __name__ == '__main__':
    unittest.main()
