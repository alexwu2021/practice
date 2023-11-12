class MinGroupInDisguise:
    def minGroups(self, intervals):
        k = 1
        A = []
        for a, b in intervals:
            A.append([a, k])
            A.append([b + 1, -k])
        res = cur = 0
        for a, diff in sorted(A):
            cur += diff
            # find the max meeting rooms used at one time
            res = max(res, cur)
        return res


intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
expected = 3
actual = MinGroupInDisguise().minGroups(intervals)
assert(expected == actual)