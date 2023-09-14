#The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

#s = "3[a]2[bc]", return "aaabcbc".
#s = "3[a2[c]]", return "accaccacc".
#s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

class Solution(object):
    """Given an encoded string, return its decoded string."""
    def decodeString(self, s):
        stack = []; curNum = 0; curString = ''
        for c in s:
            if c == '[':
                stack.append(curString)
                stack.append(curNum)
                curString = ''
                curNum = 0
            elif c == ']':
                num = stack.pop()
                prevString = stack.pop()
                curString = prevString + num*curString
            elif c.isdigit():
                curNum = curNum*10 + int(c)
            else:
                curString += c
        return curString