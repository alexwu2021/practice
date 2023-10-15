# 691. Stickers to Spell Word

from typing import List
class StickerToSpellWords:
    def minStickers(self, stickers: List[str], target: str) -> int:
        memo = {}

        def dfs(target, idx):
            if target == "":
                return 0

            if idx == len(stickers):
                return float("inf")

            key = (idx, target)
            if key in memo:
                return memo[key]

            result = dfs(target, idx + 1)

            currentSticker = stickers[idx]
            newTarget = target
            somethingRemoved = False
            for c in currentSticker:
                idxToRemove = newTarget.find(c)
                if idxToRemove != -1:
                    newTarget = newTarget[:idxToRemove] + newTarget[idxToRemove + 1:]
                    somethingRemoved = True

            if somethingRemoved:
                result = min(result, 1 + dfs(newTarget, idx))

            memo[key] = result
            return result

        result = dfs(target, 0)
        return result if result != float("inf") else -1


