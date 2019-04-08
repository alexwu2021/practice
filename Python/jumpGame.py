import unittest

class Solution(unittest.TestCase):
    #accepted, beats 14%
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        jumpt = [False] * len(nums)
        maxJump = nums[0]
        for i, v in enumerate(nums):
            if maxJump >= i:
                jumpt[i] = True #this is what we can infer: we can always choose a way to reach i as long as protected by maxJump
            if jumpt[i]:
                maxJump = max(maxJump, i + v) #update maxJump accordingly, to determine what farthest range we can jump at a jumpt location i
        return jumpt[-1]

    def test_canJump(self):
        A = [2, 3, 1, 1, 4]
        res = self.canJump(A)
        self.assertTrue(res)

        A = [1, 5, 2, 1, 0, 2, 0]
        res = self.canJump(A)
        self.assertTrue(res)

        A = [3, 2, 1, 0, 4]
        res = self.canJump(A)
        self.assertTrue(res == False)

        A = [5, 4, 3, 2, 1, 0, 0]
        res = self.canJump(A)
        self.assertTrue(res == False)


if __name__ == '__main__':
    unittest.main()
