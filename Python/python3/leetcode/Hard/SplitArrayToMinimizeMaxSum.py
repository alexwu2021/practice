from typing import List
class SplitArrayToMinimizeMaxSum:
    def splitArray(self, nums: List[int], m: int) -> int:
        def cannot_split(max_sum, m):
            num_cuts, curr_sum  = 0, 0
            for x in nums:
                curr_sum += x
                if curr_sum > max_sum:
                    num_cuts += 1
                    curr_sum = x
            return num_cuts >= m

        low, high = max(nums), sum(nums)
        while low < high:
            guess = low + (high - low) // 2
            if cannot_split(guess, m):
                low = guess + 1
            else:
                high = guess
        return low
