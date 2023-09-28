# 516. Longest Palindromic Subsequence
# Given a string s, find the longest palindromic subsequence's length in s.
#
# A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.


# idea lps = lcs(x, x.reverse())
class LongestPalindromeSubseq:

    def longestPalindromeSubseq(self, s: str) -> int:
        def lcs(x, y):
            n = len(x)
            dp = [[0] * (n + 1) for _ in range(n + 1)]
            dp[0][0] = 0
            for i in range(1, n + 1):
                for j in range(1, n + 1):
                    if x[i - 1] == y[j - 1]:
                        dp[i][j] = 1 + dp[i - 1][j - 1]
                    else:
                        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            return dp[-1][-1]
        return lcs(s, s[::-1])