from typing import List

class ArtifactDigging:

    def digArtifacts(self, n: int, artifacts: List[List[int]], dig: List[List[int]]) -> int:
        df = []
        for artifact in artifacts:
            temp = []
            r0, c0, r1, c1 = artifact[0], artifact[1], artifact[2], artifact[3]
            for r in range(r0, r1 + 1):
                for c in range(c0, c1 + 1):
                    temp.append(str(r) + "_" + str(c))
            temp.sort()
            df.append("__".join(temp))

        digstr = []
        for d in dig:
            digstr.append(str(d[0]) + "_" + str(d[1]))
        digstr.sort()
        gg = "__".join(digstr)

        ans = 0
        for dff in df:
            if dff in gg:
                ans += 1

        return ans


artifacts = [[3,1,4,1],[1,1,2,2],[1,0,2,0],[4,3,4,4],[0,3,1,4],[2,3,3,4]]
dig = [[0,0],[2,1],[2,0],[2,3],[4,3],[2,4],[4,1],[0,2],[4,0],[3,1],[1,2],[1,3],[3,2]]
n = 5

actual = ArtifactDigging().digArtifacts(n, artifacts, dig)
assert(1 == actual)