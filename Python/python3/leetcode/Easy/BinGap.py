# Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.

# 868
class BinGap:
    def binaryGap(self, N):
        index = [i for i, v in enumerate(bin(N)) if v == '1']
        return max([b - a for a, b in zip(index, index[1:])] or [0])