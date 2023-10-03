# 357

def countNumbersWithUniqueDigits(n: int) -> int:
    dp = [0] * 9
    dp[0], dp[1] = 1, 10
    s, m = 9, 10
    s *= m - 1
    m -= 1
    for i in range(2, 9):
        dp[i] = dp[i - 1] + s
        s *= m - 1
        m -= 1
    return dp[n]
