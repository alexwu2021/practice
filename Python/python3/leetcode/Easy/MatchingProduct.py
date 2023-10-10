import unittest

# Find the minimum sum of subarray

class MatchingProduct:
    def findMinimumPrice(self, price):
        n = len(price)
        prefix_sum = [0] * n
        for i in range(n):
            if i - 1 >= 0:
                prefix_sum[i] += prefix_sum[i - 1]
            prefix_sum[i] += price[i]

        from collections import defaultdict

        idxs = defaultdict(list)
        for i in range(n):
            idxs[price[i]].append(i)

        INF = 10 ** 18
        res = INF
        for key, value in idxs.items():
            m = len(value)
            for i in range(m):
                if i + 1 < m:
                    left_index, right_index = value[i], value[i + 1]
                    res = min(res, prefix_sum[right_index] - (prefix_sum[left_index - 1] if left_index - 1 >= 0 else 0))

        return -1 if res == INF else res



class TestMatchingProduct(unittest.TestCase):
    sol = MatchingProduct()
    def test1(self):
        prices = [1, 2, 3, 1, 2, 1]
        actual = self.sol.findMinimumPrice(prices)
        expected = 4
        self.assertEqual(expected, actual)

    def test2(self):
        prices = [1, 2, 1, 2]
        actual = self.sol.findMinimumPrice(prices)
        expected = 4
        self.assertEqual(expected, actual)

    def test3(self):
        prices = [1, 100, 1, 7, 7]
        actual = self.sol.findMinimumPrice(prices)
        expected = 14
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()


