class Solution(object):
    #accepted
    def matrixReshape(self, nums, r, c):
        if not nums:
            return []
        
        m = len(nums)
        n = len(nums[0])
        prod = m * n
        if r * c != prod:
            return nums
        
        res = [[0 for x in range(c)]  for _ in range(r)] #pay attention
        for i in range (prod):
            res[i // c][i % c] = nums[i // n][i % n]  # c or the old column <--> n or the new column
        return res
