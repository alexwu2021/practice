import unittest
from typing import List

class PhoneBook:
    def letterCombinations(self, digits: str) -> List[str]:
        ans = []
        if not digits: return ans

        def get_digits(i):
            if i == 2: return ['a', 'b', 'c']
            if i == 3: return ['d', 'e', 'f']
            if i == 4: return ['g', 'h', 'i']
            if i == 5: return ['j', 'k', 'l']
            if i == 6: return ['m', 'n', 'o']
            if i == 7: return ['p', 'q', 'r', 's']
            if i == 8: return ['t', 'u', 'v']
            if i == 9: return ['w', 'x', 'y', 'z']
            return []

        def dfs(digits, i, path, ans):
            if i == len(digits):
                ans.append(path)
                return

            for s in get_digits(int(digits[i])):
                path += s
                dfs(digits, i + 1, path, ans)
                path = path[:-1]

        dfs(digits, 0, "", ans)
        return ans

class TestPhoneBook(unittest.TestCase):
    sol = PhoneBook()

    def test_case1(self):
        input = "23"
        expected = ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        actual = self.sol.letterCombinations(input)
        self.assertEqual(expected, actual)



if __name__ == '__main__':
    unittest.main()


