
import unittest
from typing import List

class PredictTheWinter:

    # what is important is the maximum differences between choice rather than the actual numbers
    def predictTheWinner(self, nums: List[int]) -> bool:
        n = len(nums)
        def max_diff(left, right):
            if left == right: return nums[left]
            score_by_left = nums[left] - max_diff(left + 1, right)
            score_by_right = nums[right] - max_diff(left, right - 1)
            return max(score_by_left, score_by_right)
        return max_diff(0, n - 1) >= 0


class TestPredictTheWinter(unittest.TestCase):
    sol = PredictTheWinter()

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

