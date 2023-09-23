from typing import List
from collections import defaultdict


class EquationEval:

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:

        g = defaultdict(defaultdict)

        def backtrack_evaluate(curr, tgt, prod, visited):
            visited.add(curr)
            ret = -1.0
            neis = g[curr]
            if tgt in neis:
                ret = prod * neis[tgt]
            else:
                for nei, value in neis.items():
                    if nei in visited: continue
                    ret = backtrack_evaluate(nei, tgt, prod * value, visited)
                    if ret != -1.0: break
            visited.remove(curr)
            return ret

        # build the g
        for (dend, dsor), value in zip(equations, values):
            g[dend][dsor] = value
            g[dsor][dend] = 1 / value


        # eval
        results = []
        for dend, dsor in queries:
            if dend not in g or dsor not in g: results.append(-1.0)
            elif dend == dsor: results.append(1.0)
            else:
                ret = backtrack_evaluate(dend, dsor, 1, set())
                results.append(ret)

        return results

