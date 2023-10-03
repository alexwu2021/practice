from typing import List
import heapq_max
import unittest
class SetRightLargest:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)

        q = [x for x in arr[1:]]
        heapq_max.heapify_max(q)

        ans = [0] * n
        j = 0
        top = heapq_max.p
        while j < n - 1:
            while top < arr[j] and not q:
                top = heapq_max.heappop_max()

            ans[j] = top
            j += 1
        ans[n - 1] = -1
        return ans



class TestSetRightLargest(unittest.TestCase):
    sol = SetRightLargest()

    def test_case1(self):
        target = [17,18,5,4,6,1]
        expected = [18,6,6,6,1,-1]
        actual = self.sol.replaceElements(target)

        self.assertEqual(expected, actual)

    def test_case2(self):
        target = "101"
        expected = 3
        actual = self.sol.minFlips(target)
        self.assertEqual(expected, actual)

    def test_case3(self):
        target = "00000"
        expected = 0
        actual = self.sol.minFlips(target)
        self.assertEqual(expected, actual)

if __name__ == '__main__':
    unittest.main()
