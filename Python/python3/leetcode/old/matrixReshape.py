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
    
    def matrixReshape_somethingBad(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if not nums:
            return []
        
        
        row, col = len(nums), len(nums[0])
        if row * col != r * c:
            return nums
        lst = [nums[i][j] for i in range(row) for j in range(col)]
        res = []
        index = 0
        for x in range(r):
            temp = []
            for y in range(c):
                temp.append(lst[x * index + y])
            res.append(temp)
            index += 1
        return res
        
