# You are given an integer array deck where deck[i] represents the number written on the ith card.
#
# Partition the cards into one or more groups such that:
#
# Each group has exactly x cards where x > 1, and
# All the cards in one group have the same integer written on them.
# Return true if such partition is possible, or false otherwise.
#
#
#
# Example 1:
#
# Input: deck = [1,2,3,4,4,3,2,1]
# Output: true
# Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
# Example 2:
#
# Input: deck = [1,1,1,2,2,2,3,3]
# Output: false
# Explanation: No possible partition.


from collections import Counter
from math import gcd
from functools import reduce
class Solution:
    def hasGroupsSizeX(self, deck):
         return reduce(gcd, Counter(deck).values())>=2

# the same idea, in java

# class Solution {
#     public boolean hasGroupsSizeX(int[] deck) {
#         Map<Integer, Integer> count = new HashMap<>();
#         int res = 0;
#         for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
#
#         for (int i : count.values()) {
#             res = gcd(i, res);
#         }
#
#         return res > 1;
#     }
#
#     public int gcd(int a, int b) {
#         return b > 0 ? gcd(b, a % b) : a;
#     }
# }

