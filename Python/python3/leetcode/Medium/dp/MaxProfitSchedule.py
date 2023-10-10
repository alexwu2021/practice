# A salesman travel between two cities A and B to sell its product. On a particular day, he can either choose to sell the product or travel to other city. He cannot travel and sell on same day.
# We need to print the schedule of salesman for maximum profit earned.
#
# For example:
# Cost of selling product in city A: A = [23, 4, 5, 20]
# Cost of selling product in city B: B = [21, 1, 10 100]
#
# So max profit he can earn is by:
# Day1: Sell in City A (A)
# Day2: Travel to City B (T)
# Day3: Sell in City B (B)
# Day4: Sell in City B (B)
#
# Hence the answer should be "ATBB"
#
# Similar kind of problem with some addon https://leetcode.com/discuss/interview-question/762690/google-telephone-interview-coding-question.
# We need to account for travel and print the max profit schedule as String.

from typing import List


def maxProfitSchedule(A: List[int], B: List[int]) -> str:
    n, currA, currB = len(A), A[0], B[0]
    prepreA, prepreB = 0, 0
    pathA, pathB = ["A"] * n, ["B"] * n
    for i in range(1, n):
        preA = currA
        preB = currB
        if prepreB > preA:
            currA = prepreB + A[i]
            # store the previous day as 'Travel'
            pathA[i - 1] = "T"
        else:
            currA = preA + A[i]
        if prepreA > preB:
            currB = prepreA + B[i]
            # store the previous day as 'Travel'
            pathB[i - 1] = "T"
        else:
            currB = preB + B[i]
        prepreA = preA
        prepreB = preB
    currPath = pathA if currA > currB else pathB

    path = []
    # process the path from back to the front
    for i in range(n - 1, -1, -1):
        path.append(currPath[i])
        # when the day is 'Travel' switch to the other path
        if currPath[i] == "T":
            currPath = pathB if currPath == pathA else pathA
    return "".join(path[::-1])


A = [23, 4, 5, 20]
B = [21, 1, 10, 100]

assert maxProfitSchedule(A, B) == "ATBB"

# A = [23, 4, 5, 20]
# B = [21, 1, 10, 100]
# #
# C = [[0] + A, [0] + B]
#
#
# @cache
# def dp(i, j, k):
#     global res
#     if i == len(A) + 1: return 0
#
#     a = C[j][i] + dp(i + 1, j, 0)
#     b = dp(i + 1, 1 - j, 0)
#
#     if k:
#         res += ['AB'[j], 'T'][a < b]
#         dp(i + 1, j ^ (a < b), 1)
#
#     return max(a, b)
#
#
# res = ''
# dp(0, 0, 1)
#
# return res[1:]
