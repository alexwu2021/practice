
# You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.
#
# We want to place these books in order onto bookcase shelves that have a total width shelfWidth.
#
# We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.
#
# Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.
#
# For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
# Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

from typing import List
from math import inf

class MinBookshelfHeight:

    # width, height = books[i][0], books[i][1]

    def minHeightShelves(self, books: List[List[int]], shelf_width: int) -> int:
        n = len(books)
        dp = [0] + [inf] * n   # dp[i] := the min height up to i

        for i in range(1, n + 1):
            w, h, j = 0, 0, i

            # right adjusted layout, while the first row could be very sparse
            while j and w + books[j - 1][0] <= shelf_width:
                h = max(h, books[j - 1][1])
                w += books[j - 1][0]

                dp[i] = min(dp[i], dp[j - 1] + h)

                j -= 1

        return dp[-1]


#
#
# books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]
# shelfWidth = 4
# expected = 6
# assert(MinBookshelfHeight().minHeightShelves(books, shelfWidth) == expected)

books = [[1,3],[2,4],[3,2]]
shelfWidth = 6
expected = 4
assert(MinBookshelfHeight().minHeightShelves(books, shelfWidth) == expected)
