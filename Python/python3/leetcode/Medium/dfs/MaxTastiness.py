import unittest
from typing import List
from functools import cache


# 2431. Maximize Total Tastiness of Purchased Fruits
# improvement: sorted to decreasing order and then do the same

class MaxTastiness:
    def maxTastiness(self, price: List[int], tastiness: List[int], maxAmount: int, maxCoupons: int) -> int:
        n = len(price)

        @cache
        def dfs(indx, amount, coupon):
            if indx == n: return 0
            ans = 0
            ans = max(ans, dfs(indx + 1, amount, coupon))  ## do not buy this fruit
            if amount >= price[indx]:  ## buy this fruit without coupon
                ans = max(ans, tastiness[indx] + dfs(indx + 1, amount - price[indx], coupon))
            if coupon >= 1 and amount >= price[indx] // 2:  ## buy this fruit with coupon
                ans = max(ans, tastiness[indx] + dfs(indx + 1, amount - (price[indx] // 2), coupon - 1))
            return ans

        return dfs(0, maxAmount, maxCoupons)


class TestMaxTastiness(unittest.TestCase):
    sol = MaxTastiness()

    def test_case1(self):
        price = [10, 20, 20]
        tastiness = [5, 8, 8]
        maxAmount = 20
        maxCoupons = 1
        expected = 13
        actual = self.sol.maxTastiness(price, tastiness, maxAmount, maxCoupons)
        self.assertEqual(expected, actual)

    def test_case2(self):
        price = [10, 15, 7]
        tastiness = [5, 8, 20]
        maxAmount = 10
        maxCoupons = 2
        expected = 28
        actual = self.sol.maxTastiness(price, tastiness, maxAmount, maxCoupons)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
