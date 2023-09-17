import unittest


class LargestGoodInteger:
    def largestGoodInteger(self, num: str) -> str:
        mx = -1
        if num == None or len(num) < 3:
            return ""

        i, j, k = 0, 1, 2
        while i <= len(num) -3:
            j = i + 1
            if num[i] != num[j]:
                i = j
                continue

            k = j + 1
            if num[k] != num[j]:
                i = k
                continue


            if num[i] == num[j] and num[j] == num[k]:
                mx = max(mx, int(num[i]) * 100 + int(num[j]) * 10 + int(num[k]))
            i += 1

        if mx == 0: return "000"
        return "" if mx == -1 else str(mx)

class TestLargestGoodInteger(unittest.TestCase):
    sol = LargestGoodInteger()

    def test_case1(self):
        num = "6777133339"
        actual = self.sol.largestGoodInteger(num)
        expected = "777"
        self.assertEqual(expected, actual)


    def test_case2(self):
        num = "6000"
        actual = self.sol.largestGoodInteger(num)
        expected = "000"
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()


