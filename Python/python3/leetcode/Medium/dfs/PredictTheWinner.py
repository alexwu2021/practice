
import unittest
from typing import List

class PredictTheWinner:


    # what is important is the maximum differences between choice rather than the actual numbers
    def predictTheWinner(self, nums: List[int]) -> bool:

        def dfs(left, right):
            if left == right: return nums[left]
            return max(nums[left] - dfs(left + 1, right), nums[right] - dfs(left, right - 1))
        return dfs(0, len(nums) - 1) >= 0  # which diff emerges out as the winner: positive or negative
        #
        # def dfs_also_works(nums, left, right):
        #     if left == right: return nums[left]
        #         return max(nums[left] - dfs_also_works(nums, left + 1, right), nums[right] - dfs_also_works(nums, left, right - 1))
        #     return dfs(nums, 0, len(nums) - 1) >= 0


class TestPredictTheWinter(unittest.TestCase):
    sol = PredictTheWinner()

    def test_case1(self):
        input = [1,5,2]
        expected = False
        actual = self.sol.predictTheWinner(input)
        self.assertEqual(expected, actual)

    def test_case2(self):
        input = [1,5,233,7]
        expected = True
        actual = self.sol.predictTheWinner(input)
        self.assertEqual(expected, actual)




if __name__ == '__main__':
    unittest.main()

