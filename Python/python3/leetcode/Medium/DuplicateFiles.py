from typing import List
from collections import defaultdict


class DuplicateFiles:

    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        hash_map = defaultdict(list)
        for i in paths:
            new_line = i.split(' ')
            root = new_line[0]
            for value in new_line[1:]:
                test = value.split('.txt')
                hash_map[test[1]].append(f'{root}/{test[0]}.txt')
        output = []
        for key, value in hash_map.items():
            if len(value) > 1:
                output.append(value)
        return output
    def findDuplicate2(self, paths: List[str]) -> List[List[str]]:
        d = defaultdict(list)
        for path in paths:
            sa = path.split()
            for i in range(1, len(sa)):
                li = sa[i].find("(")
                file_name = sa[0] + "/" + sa[i][0:li]
                content = sa[i][li + 1:-1]
                # print("content: %s; file_name: %s" % (content, file_name))
                d[content].append(file_name)

        ans = []
        for k, v in d.items():
            if len(v) > 1:
                temp = list(set(v))
                ans.append(temp)
        return ans


input = ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
actual = DuplicateFiles().findDuplicate(input)
expected = ["root/a/2.txt", "root/c/d/4.txt", "root/4.txt"], ["root/a/1.txt", "root/c/3.txt"]
assert (expected, actual)

# Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
# Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
# Example 2:
#
# Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
# Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
