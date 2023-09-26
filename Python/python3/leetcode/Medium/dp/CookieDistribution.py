from typing import List

# 2305
# You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the cookies in the same bag must go to the same child and cannot be split up.
# The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
# Return the minimum unfairness of all distributions.
class CookieDistribution:

    def distributeCookies(self, cookies: List[int], k: int) -> int:
        dist_rec = [0] * k
        n = len(cookies)

        def dfs(i, kids_to_cover):
            if n - i < kids_to_cover: # unable to distribute
                return float('inf')

            if i == n:
                return max(dist_rec)

            answer = float('inf')
            for j in range(k):
                # if the current element in dist_rec is in the initialized state, then it will be excluded in the next dfs call
                kids_to_cover -= int(dist_rec[j] == 0)

                dist_rec[j] += cookies[i]

                # one step further, possibly with one less kid to take care of
                answer = min(answer, dfs(i + 1, kids_to_cover))

                # tail spin
                dist_rec[j] -= cookies[i]
                kids_to_cover += int(dist_rec[j] == 0)

            return answer

        return dfs(0, k)