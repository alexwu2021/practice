# 132.
# Given a string s, partition s such that every
# substring of the partition is a palindrome

# Return the minimum cuts needed for a palindrome partitioning of s.


class PalindromePartitioning2:

    def minCut(self, s: str) -> int:
        n = len(s)
        dp = [-1] + [n] * n
        for i in range(2 * n - 1):
            l = i // 2
            r = l + (i & 1)
            while 0 <= l and r < n and s[l] == s[r]:
                dp[r + 1] = min(dp[r + 1], dp[l] + 1)
                l -= 1
                r += 1
        return dp[-1]

