# 799.

class ChampagnePouring:

    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        t = [[0] * (i + 1) for i in range(query_row + 1)]  # 1, 2, 3, ...
        t[0][0] = poured
        for r in range(query_row):
            for c in range(len(t[r])):
                if t[r][c] < 1:
                    continue
                excess = (t[r][c] - 1) / 2.0
                t[r + 1][c] += excess
                t[r + 1][c + 1] += excess
        return min(1.0, t[query_row][query_glass])

