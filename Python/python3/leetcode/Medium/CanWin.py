class CanWin:

    #  for(int i=1;i<s.length();i++){
    #             if(s.charAt(i)=='+'&&s.charAt(i-1)=='+' &&!canWin(s.substring(0,i-1)+"--"+s.substring(i+1,s.length())) ){
    #                /*自己能翻牌+敌人会输=我们赢*/
    #                 return true;
    #             }
    #         }
    #
    #         return false;

    def canWin(self, s):
        for i in range(1, len(s)):
            if s[i] == '+' and s[i - 1] == '+' and not self.canWin(s[:i - 1] + '--' + s[i + 1:]):
                return True
        return False

    # def canWin(self, s: str) -> bool:
    #     n = len(s)
    #     for i in range(1, n):
    #         if s[i] == s[i + 1] and s[i] == '+' and self.canWin(s[0:i - 1] + "--" + s[i:n]):
    #             return True
    #     return False

    # boolean canWin(String s) {
    #     for (int i=1;i < s.length();i++){
    #         if (s.charAt(i) == '+' & & s.charAt(i-1) == '+' & & !canWin(s.substring(0, i-1)+"--"+s.substring(i+1, s.length())) ){
    #             return true;
    #         }
    #     }
    #     return false;
    # }


    def canWin_poor(self, currentState: str) -> bool:
        n = len(currentState)
        if n <= 1: return False
        dp = [[False] * n for _ in range(2)]
        if currentState[-1] == currentState[-2] and currentState[-1] == '+':
            dp[0][n - 2] = True

        for i in range(n - 3, -1, -1):
            if currentState[i] == currentState[i + 1] and currentState[i]:
                if currentState[i] == '+':
                    if dp[1][i + 2] or not dp[0][i + 2]:
                        dp[0][i] = True
                        dp[1][i + 1] = dp[0][i+1]
                    else:
                        dp[1][i] = True
        return dp[0][0]

currentState = "++++"
actual = CanWin().canWin(currentState)
expected = True
assert(expected == actual)



currentState = "+++++"
actual = CanWin().canWin(currentState)
expected = False
assert(expected == actual)
