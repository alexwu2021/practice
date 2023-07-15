class Solution:

    #brute force
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        st = set()
        for i in range(0, len(nums)-1):
            for j in range(i+1, len(nums)):
                if abs(nums[i]-nums[j]) == k:
                    if nums[i] < nums[j] :
                        st.add((nums[i], nums[j]))
                    else:
                        st.add((nums[j], nums[i]))
        return len(st)

    #accepted
    def findPairs(self, nums, k):
        res = 0
        c = collections.Counter(nums)
        for i in c:
            if (k > 0 and i + k in c) or (k == 0 and c[i] > 1):
                res += 1
        return res
