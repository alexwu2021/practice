import math


# [2, 5, 3, 6, 4, 1, 9, 7]
# Here's what the sparse table would look like for this array:
# This array determines the minimum of every range of length 2^j for each index i:
#
# [2, 2, 2, 2, 1, 1, 1, 1]
# [5, 3, 3, 1, 1, 1, 1, 0]
# [3, 3, 3, 1, 1, 1, 1, 0]
# [6, 4, 1, 1, 1, 1, 0, 0]
# [4, 1, 1, 1, 1, 1, 0, 0]
# [1, 1, 1, 1, 1, 1, 0, 0]
# [9, 7, 0, 0, 0, 0, 0, 0]
# [7, 0, 0, 0, 0, 0, 0, 0]

# Let's say we want to answer the range minimum query for the range [2, 5]. We can do this by taking the minimum of the two overlapping ranges of length 2^2 that cover the range [2, 5]:
#
# [3, 3, 3, 1, 1, 1, 1, 0]
# [6, 4, 1, 1, 1, 1, 0, 0]
# The minimum of these two ranges is 1, which is the correct answer.

class SparseTable:
    def __init__(self, arr):
        self.n = len(arr)
        self.log_n = int(math.log2(self.n)) + 1
        self.sparse_table = [[0] * self.log_n for _ in range(self.n)]

        for i in range(self.n):
            self.sparse_table[i][0] = arr[i]

        for j in range(1, self.log_n):
            for i in range(self.n - (1 << j) + 1):
                self.sparse_table[i][j] = min(self.sparse_table[i][j - 1], self.sparse_table[i + (1 << (j - 1))][j - 1])


    # range query
    def query(self, L, R):
        k = int(math.log2(R - L + 1))
        return min(self.sparse_table[L][k], self.sparse_table[R - (1 << k) + 1][k])




# Advantages and Disadvantages of Sparse Tables
#
# Sparse tables are a very simple data structure that can be used to answer range queries efficiently. They are particularly useful when you have a static array and need to perform multiple range queries efficiently, such as finding the minimum/maximum value in a subarray.
#
# However, sparse tables have some disadvantages as well:
#
# They take O(n * log n) time to construct, which is not always feasible for large arrays.
#
# They take up a lot of space, which can be a problem if you have a large array.
#
# They are not very flexible. For example, if you want to find the minimum/maximum value in a subarray of length 3, you cannot use a sparse table because it only works for ranges of length 2^j.
#
# They are not very efficient for dynamic arrays. If you have a dynamic array, you can use a segment tree instead of a sparse table to answer range queries efficiently.
#
# Types of Sparse Tables
#
# There are two main types of sparse tables:
#
# Static Sparse Tables: These are sparse tables that are built once and then used to answer range queries on a static array. They are usually constructed using a bottom-up approach, where you start with the input array and then build the sparse table by computing the minimum of every range of length 2^j for each index i.
#
# Dynamic Sparse Tables: These are sparse tables that are built once and then used to answer range queries on a dynamic array. They are usually constructed using a top-down approach, where you start with the input array and then build the sparse table by computing the minimum of every range of length 2^j for each index i.
#
# Problems
#
# SPOJ - RMQSQ
# SPOJ - RMQ2
# SPOJ - RMQ
# Alternatives to Sparse Tables
#
# There are several alternatives to sparse tables that can be used to answer range queries efficiently:
#
# Segment Trees: Segment trees are a data structure that can be used to answer range queries efficiently. They are particularly useful when you have a dynamic array and need to perform multiple range queries efficiently, such as finding the minimum/maximum value in a subarray.
#
# Binary Indexed Trees: Binary indexed trees are a data structure that can be used to answer range queries efficiently. They are particularly useful when you have a dynamic array and need to perform multiple range queries efficiently, such as finding the minimum/maximum value in a subarray.
#
# Wavelet Trees: A wavelet tree is a data structure used for various range query operations on a sequence of elements, particularly for efficient range queries in binary strings or arrays. It's often used in applications related to text indexing, but it can be adapted to other scenarios as well.
#
# LeetCode Problems Set
#
# Range Sum Query - Immutable
#
# LeetCode - 1521
#
# LeetCode - 1649
#
# LeetCode - 1851
#
# LeetCode - 654
#
# Codeforces Problems Set
#
# Codeforces - 339D
#
# Codeforces - 380C