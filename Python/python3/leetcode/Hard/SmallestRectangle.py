from typing import List

# 307

# You are given an m x n binary matrix image where 0 represents a white pixel and 1 represents a black pixel.
#
# The black pixels are connected (i.e., there is only one black region). Pixels are connected horizontally and vertically.
#
# Given two integers x and y that represents the location of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
#
# You must write an algorithm with less than O(mn) runtime complexity
class SmallestRectangle:

    def minArea(self, image: List[List[str]], x: int, y: int) -> int:  # x and y can be taken as the starting point
        M, N = len(image), len(image[0])
        top, left, right, bottom = x, y, y + 1, x + 1
        stack = [(x, y)]
        while stack:
            x, y = stack.pop()
            top, left, right, bottom = min(x, top), min(y, left), max(y + 1, right), max(x + 1, bottom) # further adjust the bourdaries
            image[x][y] = '0'
            for r, c in [(x - 1, y), (x, y - 1), (x, y + 1), (x + 1, y)]:
                if 0 <= r < M and 0 <= c < N and image[r][c] == '1':
                    stack.append((r, c))
        return (bottom - top) * (right - left)