from functools import lru_cache


# 526

# Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
#
# perm[i] is divisible by i.
# i is divisible by perm[i].
# Given an integer n, return the number of the beautiful arrangements that you can construct.
class BeautifulArrangement:
    def countArrangement(self, n: int) -> int:
        @lru_cache(None)
        def dfs(bitmask = 0, idx = 1):
            if bitmask == 2 ** n - 1:
                return 1
            total = 0
            for i in range(1, n + 1):
                if bitmask & (1 << (i - 1)):
                    continue
                if idx % i == 0 or i % idx == 0:
                    total += dfs(bitmask | (1 << (i - 1)), idx + 1)
            return total

        return dfs()

n = 3
actual = BeautifulArrangement.countArrangement(n)
expected = 3
assert(expected == actual)


#If N = 3, i is 1-based index

# perm[i] is divisible by i or i is divisible by perm[i].

# 1 2 3 - yes
# 1 3 2 - Not a beautiful arrangement cause 3 ( value at index i = 2) is not divisible by 2.
# 2 1 3 - yes
                # i == 2 ==> when index == 1, perm[1] == 1, i % perm[1] == 2 % 1 == 0
# 2 3 1 - Not a beautiful arrangement cause 3 ( value at index i = 2) is not divisible by 2.
# 3 1 2 - yes
# 3 2 1 - Not a beautiful arrangement cause 1 ( value at index i = 3) is not divisible by 3.
#
