class MakeStringGood:
    def makeGood(self, s: str) -> str:
        stack = []
        for c in s:
            if stack and abs(ord(c) - ord(stack[-1])) == 32:
                stack.pop()
            else:
                stack.append(c)
        return ''.join(stack)


s = "leEeetcode"
expected = "leetcode"
actual =  MakeStringGood().makeGood(s)
print("actual: %s" % actual)
assert(actual == expected)


s = "abBAcC"
expected = ""
actual =  MakeStringGood().makeGood(s)
print("actual: %s" % actual)
assert(actual == expected)
