import unittest
from typing import List
from functools import cache

class ShoppingOffers:

    def shoppingOffers(self, prices: List[int], specials: List[List[int]], needs: List[int]) -> int:

        @cache
        def fn(*args):
            ans = sum(x * y for x, y in zip(args, prices))
            for offer in specials:
                if all(x >= y for x, y in zip(args, offer)):
                    ans = min(ans, fn(*(x - y for x, y in zip(args, offer))) + offer[-1])
            return ans
        return fn(*needs)

class TestShoppingOffers(unittest.TestCase):
    sol = ShoppingOffers()

    def test_case1(self):
        prices = [2, 5]
        specials = [[3, 0, 5], [1, 2, 10]]
        needs = [3, 2]
        expected = 14
        actual = self.sol.shoppingOffers(prices, specials, needs)
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()

