
# 466

# We define str = [s, n] as the string str which consists of the string s concatenated n times.
#
# For example, str == ["abc", 3] =="abcabcabc".
# We define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1.
#
# For example, s1 = "abc" can be obtained from s2 = "abdbec" based on our definition by removing the bolded underlined characters.
# You are given two strings s1 and s2 and two integers n1 and n2. You have the two strings str1 = [s1, n1] and str2 = [s2, n2].
#
# Return the maximum integer m such that str = [str2, m] can be obtained from str1.

class GetMaxRepetitions:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        l1, l2 = len(s1), len(s2)
        total1 = l1 * n1
        i1 = i2 = 0
        d = {}  # 1:1 mapping from (relative) offset tuple to (absolute)index tuple

        while i1 < total1:
            offset1, offset2 = i1 % l1, i2 % l2
            if s1[offset1] == s2[offset2]:
                if (offset1, offset2) in d:
                    # tap on the cyclical nature
                    prev_index1, prev_index2 = d[(offset1, offset2)]
                    stride1, stride2 = i1 - prev_index1, i2 - prev_index2
                    num_jumps = (total1 - i1) // stride1

                    # jump and check
                    i1 += num_jumps * stride1
                    if i1 >= total1:
                        break
                    i2 += num_jumps * stride2

                else:
                    d[(offset1, offset2)] = (i1, i2)
                i2 += 1
            i1 += 1
        return i2 // l2 // n2


# s1 = "acb"
# n1 = 4
# s2 = "ab"
# n2 = 2
# actual = GetMaxRepetitions().getMaxRepetitions(s1, n1, s2, n2)
# expected = 2
# assert(expected == actual)

s1 = "acb"
n1 = 1
s2 = "acb"
n2 = 1
actual = GetMaxRepetitions().getMaxRepetitions(s1, n1, s2, n2)
expected = 1
assert(expected == actual)

