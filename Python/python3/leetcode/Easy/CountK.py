import unittest

class CountK:

    #twisted for logn
    def countK(self, k, nums, N):
        ans = 0

        def dfs(s, e):
            nonlocal ans
            if nums[s] == k and nums[e] == k:
                ans += N
                return N


            left, right = s, e
            while left < right:
                m = left + (right -left) // 2
                if nums[m] == nums[right] and nums[m] == k:
                    ans += right - m + 1
                    right = m - 1
                elif nums[m] == nums[left] and nums[m] == k:
                    ans += m - left + 1
                    left = m + 1
                elif nums[m] == k:
                    ans += 1
                    return dfs(left, m-1) + dfs(m+1, right)
                else:
                    if nums[m] > k:
                        right = m  # because we are use floor(), so not use m -1 to exclude the element at index m-1
                    else:
                        left = m + 1
            return 0


        dfs(0, N - 1)
        return ans

class TestCountK(unittest.TestCase):
    sol = CountK()

    def test_case1(self):
        k = 7
        nums = [1, 2, 3, 7, 7, 7, 9, 9]
        n = len(nums)
        actual = self.sol.countK(k, nums, n)
        expected = 3
        self.assertEqual(expected, actual)

    def test_case2(self):
        k = 3
        nums = [1, 2, 3, 7, 7, 7, 9, 9]
        n = len(nums)
        actual = self.sol.countK(k, nums, n)
        expected = 1
        self.assertEqual(expected, actual)

    def test_case3(self):
        k = 9
        nums = [1, 2, 3, 7, 7, 7, 9, 9]
        n = len(nums)
        actual = self.sol.countK(k, nums, n)
        expected = 2
        self.assertEqual(expected, actual)

    def test_case4(self):
        k = 9
        nums = [9, 9, 9]
        n = len(nums)
        actual = self.sol.countK(k, nums, n)
        expected = 3
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()

