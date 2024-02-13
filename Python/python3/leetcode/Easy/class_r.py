# Write a program that provides the max value of sum of any 2 numbers in an array / list
import random
import sys
import unittest

class ClassR:

    @staticmethod
    def get_max_of_streaming():
        first = second = -sys.maxsize
        count = 0
        num = random.randint(-1, 1000)

        while num != -1 or count < 100:
            print("num: %d, count: %d, first: %d, second: %d" % (num, count, first, second))
            count += 1
            if first == -sys.maxsize:
                first = num
            elif second == -sys.maxsize:
                second = min(num, first)
                first = max(num, first)
            else:
                if num <= second:
                    num = random.randint(-1, 1000)
                    continue
                if num >= first:
                    second, first = first, num
                else:  # first > num > second
                    second = num

            num = random.randint(-1, 1000)

        if second == -sys.maxsize:
            raise "unexpected error: deficient number of elements encountered"
        return first + second

    @staticmethod
    def get_max(lst):
        if not lst:
            raise ("Error: source input is null or empty")
        if len(lst) == 1:
            return lst[0]

        first = -sys.maxsize
        max_index = -1
        for i in range(len(lst)):
            if first < lst[i]:
                first, max_index = lst[i], i

        sec = -sys.maxsize
        for j in range(len(lst)):
            if sec < lst[j] and j != max_index:
                sec = lst[j]
        return first + sec


class TestCountK(unittest.TestCase):

    def test_get_max(self):
        input = [4, 5]
        actual = ClassR().get_max(input)
        expected = 9
        self.assertEqual(expected, actual)

        input = [4, 5, 7, 8, 9, 10]
        actual = ClassR().get_max(input)
        expected = 19
        self.assertEqual(expected, actual)

        input = [20, 5, 7, 8, 9, 10]
        actual = ClassR().get_max(input)
        expected = 30
        self.assertEqual(expected, actual)

    def test_get_max_of_streaming(self):
        actual = ClassR().get_max_of_streaming()
        print("actual: %d" % actual)
        self.assertTrue(actual > 0)


if __name__ == '__main__':
    unittest.main()
