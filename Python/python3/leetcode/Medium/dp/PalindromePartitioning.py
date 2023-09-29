# 131.
# Palindrome
# Partitioning


class PalindromePartitioning:

    def partition(self, s):
        def is_palindrome(start, end):
            return s[start:end + 1] == s[s:end + 1][::-1]

        def dfs(i, path):
            nonlocal res
            if i >= len(s):
                res.append(path)

            for l in range(len(s) - i):
                if is_palindrome(i, i + l):
                    dfs(i + l + 1, path + [s[i:i + l + 1]])

        res = []
        dfs(0, [])
        return res

