from collections import Counter
class Solution:
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.intersect(nums2, nums1)
        
        res = []
        st = Counter(nums2)
        for n in nums1:
            if n in st and st[n] > 0:
                st[n] -= 1
                res.append(n)
        return res
    
    #min(n1, n2) log(n)