import unittest

#2040

class KthSmallestProduct:
    def kthSmallestProduct(self, A, B, k):
        A1, A2 = [-a for a in A if a < 0][::-1], [a for a in A if a >= 0]
        B1, B2 = [-a for a in B if a < 0][::-1], [a for a in B if a >= 0]

        neg = len(A1) * len(B2) + len(A2) * len(B1)
        if k > neg:
            k -= neg
            s = 1
        else:
            k = neg - k + 1
            B1, B2 = B2, B1
            s = -1

        def count(A, B, x):
            res = 0
            j = len(B) - 1
            for i in range(len(A)):
                while j >= 0 and A[i] * B[j] > x:
                    j -= 1
                res += j + 1
            return res

        left, right = 0, 10 ** 10
        while left < right:
            mid = left + (right - left) // 2
            if count(A1, B1, mid) + count(A2, B2, mid) >= k:
                right = mid
            else:
                left = mid + 1
        return left * s


sol = KthSmallestProduct()
nums1 = [2,5]
nums2 = [3,4]
k = 2
actual = sol.kthSmallestProduct(nums1, nums2, k)
expected = 8
assert(expected == actual)

nums1 = [-4,-2,0,3]
nums2 = [2,4]
k = 6
actual = sol.kthSmallestProduct(nums1, nums2, k)
expected = 0
assert(expected == actual)


nums1 = [-2,-1,0,1,2]
nums2 = [-3,-1,2,4,5]
k = 3
actual = sol.kthSmallestProduct(nums1, nums2, k)
expected = -6
assert(expected == actual)

