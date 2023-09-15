from typing import List

class TrapRainWater:

    def trap(self, height: List[int]) -> int:
        ans = 0
        i = 0
        stk = []
        while i < len(height):
            while len(stk) > 0 and height[i] > stk[-1]:
                oldStackHi = stk[-1]
                stk = stk[0:-2]

                if len(stk) == 0: break

                dist = i - stk[-1] - 1
                newHigherHi = min(stk[-1], height[i])
                ans += dist * (newHigherHi - oldStackHi)

            stk.append(i)
            i += 1

        return ans