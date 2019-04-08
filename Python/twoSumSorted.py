  def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(numbers) <= 1:
            return [-1, -1]    
        
        i, j = 0, len(numbers)-1
        while i < j:
            if target == numbers[i] + numbers[j]:
                return [i+1, j + 1]
            if target > (numbers[i] + numbers[j]):
                i += 1
                continue
            if target <(numbers[i] + numbers[j]):
                j -= 1
                continue
        return [-1, -1]