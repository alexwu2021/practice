class Solution:
    def coinChange(self, coins, val):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        mx = float('inf')  #can't just maxsize, it won't work
        dp =[0] + [mx] * val
        for i in range(1, val+1):
            dp[i] = min(dp[i-c] if i - c >= 0 else mx for c in coins) + 1

        return [dp[val], -1] [dp[val] == mx]
    
    def coinChange_others(self, coins, amount):
        MAX = float('inf')
        dp = [0] + [MAX] * amount

        for i in xrange(1, amount + 1):
            dp[i] = min([dp[i - c] if i - c >= 0 else MAX for c in coins]) + 1

        return [dp[amount], -1][dp[amount] == MAX]