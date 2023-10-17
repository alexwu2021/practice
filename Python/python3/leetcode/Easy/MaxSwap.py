import sys
import unittest
class MaxSwap:
    def maximumSwap(self, num: int) -> int:
        num = [int(digit) for digit in str(num)]

        def solve(num):
            if not num:
                return num
            max_num = max(num)
            if max_num == num[0]:
                return [num[0]] + solve(num[1:])

            # get the last index of max element
            index = num[::-1].index(max_num)

            # add 1 to the index so that we can use the index for negative indexing on the original num
            index = index + 1

            num[0], num[-index] = num[-index], num[0]
            return num

        return int(''.join(str(digit) for digit in solve(num)))

assert (MaxSwap().maximumSwap(2798) == 9728)  # 9193
assert (MaxSwap().maximumSwap(1993) == 9913)  # 9193
assert (MaxSwap().maximumSwap(98185) == 98815)  # 9193