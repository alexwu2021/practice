
class Solution:
    #accepted
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1, 1]
        lst = [1, 1]
        for i in range(2, rowIndex+ 1):
            newList = [1]
            length = len(lst)
            for j in range(length-1):
                newList.append(lst[j] + lst[j+1])
            newList.append(1)
            print('newList: %s' % newList)
            lst = newList
        return lst



s = Solution()
res = s.getRow(2)
print('res: %s' % res)
