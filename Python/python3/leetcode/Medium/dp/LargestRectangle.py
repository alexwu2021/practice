from typing import List


class LargestRectangle:
    def largestRectangle(self, a: List[int]) -> int:
        ans = 0

        # calc while build the stack
        stack = [-1]
        for i in range(len(a)):
            while stack[-1] != -1 and a[stack[-1]] >= a[i]:
                ans = max(ans, (i - stack[-1] - 1) * a[stack.pop()])
            stack.append(i)

        # stack wing down
        while stack[-1] != -1:
            width = len(a) - stack[-1] - 1
            ans = max(ans, a[stack.pop()] * width)
        return ans

    def largestRectangle(self, a: List[int]) -> int:
        stack = [-1]
        ans = 0

        for i in range(len(a)):
            while stack[-1] != -1 and a[stack[-1]] >= a[i]:
                current_height = a[stack.pop()]
                current_width = i - stack[-1] - 1
                ans = max(ans, current_height * current_width)
            stack.append(i)

        while stack[-1] != -1:
            current_height = a[stack.pop()]
            current_width = len(a) - stack[-1] - 1
            ans = max(ans, current_height * current_width)
        return ans