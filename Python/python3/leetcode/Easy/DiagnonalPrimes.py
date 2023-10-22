import unittest
from typing import List
class DiagonalPrimes:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        n = len(nums)
        def is_prime(num):
            if num <= 1:
                return False
            for i in range(2, int(num ** 0.5) + 1):
                if num % i == 0:
                    return False
            return True

        p = 0
        for i in range(n):
            if is_prime(nums[i][i]):
                p = max(p, nums[i][i])
            if is_prime(nums[i][n - 1 - i]):
                p = max(p, nums[i][n - 1 - i])
        return p

nums = [[1,2,3],[5,6,7],[9,10,11]]
assert(DiagonalPrimes().diagonalPrime(nums) == 11)