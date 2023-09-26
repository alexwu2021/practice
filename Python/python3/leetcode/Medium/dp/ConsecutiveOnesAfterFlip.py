import unittest
from typing import List

# for a given 0, 1 list, find out the max consecutive 1s with 1 flip allowed

class ConsecutiveOnesAfterFlip:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        findex = -1 # last flip index
        count, temp = 0, 0
        for i, v in enumerate(nums):
            if v == 1:
                temp += 1
            elif findex == -1:
                temp += 1
                findex = i
            else:
                temp = i - findex  # the current i is on zero
                findex = i
            count = max(count, temp)
        return count




class TestConsecutiveOnesAfterFlip(unittest.TestCase):
    sol = ConsecutiveOnesAfterFlip()

    def test_case1(self):
        input = [1,0,1,1,0]
        expected = 4
        actual = self.sol.findMaxConsecutiveOnes(input)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
