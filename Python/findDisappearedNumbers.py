class Solution:
    #accepted
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ret = []
        if not nums or len(nums)==0:
            return ret
        st = set(nums)
        for n in range(1, len(nums)+1):
            if n not in st:
                ret.append(n)
        return ret

s = Solution()
nums = [4,3,2,7,8,2,3,1]
ret = s.findDisappearedNumbers(nums)
print(ret)
