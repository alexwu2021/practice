import collections


class MatrixDiagnoSort:
    def diagonalSort(self, A):
        rows, colls = len(A), len(A[0])
        d = collections.defaultdict(list)
        for r in range(rows):
            for c in range(colls):
                d[r - c].append(A[r][c])
        for k in d:
            d[k].sort(reverse=True)
        for r in range(rows):
            for c in range(colls):
                A[r][c] = d[r - c].pop()
        return A







# perience in SRE / DevOps / Cloud Engineering / Sys or Network AdminsExperience with monitoring, troubleshooting, and working in production environments Experience working with Linux flavorsA background in Shell/Python scriptingExperience with monitoring tools (e.g., Grafana, Prometheus)Hands-on experience working with any of the major cloud providers Willingness to work in a fast-paced environment, including 24/7 availabilityWhile this position is remote, the ideal candidate will be located in MST/PST time zones or be willing to work PST hours.Extra great if you have: Familiarity with networking and FW technologyA “team player” attitudeAbility to learn on your own Familiarity with JenkinsExperience with automation tools (e.g., Chef, Puppet)We give back to our employees: Our culture is what makes Redis a fun and rewarding place to work.





mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
expected = [[1, 1, 1, 1], [1, 2, 2, 2], [1, 2, 3, 3]]
actual = MatrixDiagnoSort().diagonalSort(mat)
assert(expected == actual)