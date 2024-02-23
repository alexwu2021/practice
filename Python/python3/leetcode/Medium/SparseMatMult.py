# 311
# Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
#

from typing import List

class SparseMatMult:

    def multiply(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        a_rows, a_cols = len(A), len(A[0])
        b_rows, b_cols = len(B), len(B[0])
        ans = [[0 for _ in range(b_cols)] for _ in range(a_rows)]
        a_mp = [dict() for _ in range(a_rows)]
        b_mp = [dict() for _ in range(b_cols)]
        for r in range(a_rows):
            for c in range(a_cols):
                if A[r][c] != 0:
                    a_mp[r][c] = A[r][c]
        for r in range(b_rows):
            for c in range(b_cols):
                if B[r][c] != 0:
                    b_mp[c][r] = B[r][c]
        for r in range(a_rows):
            for c in range(b_cols):
                ans[r][c] = sum(a_mp[r][k] * b_mp[c][k] for k in a_mp[r] if k in b_mp[c])
        return ans




mat1 = [[1,0,0],[-1,0,3]]
mat2 = [[7,0,0],[0,0,0],[0,0,1]]
expected = [[7,0,0],[-7,0,3]]

actual = SparseMatMult().multiply(mat1, mat2)
assert(expected == actual)