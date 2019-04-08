#import unittest


def maxHolidays(days, flights):
    print ('days %d, flights %d' % (len(days), len(flights)))
    n = len(flights)
    K = len(days[0])
    
    d = [[0] * (n + 1)] * K

    for c in range(K):
        d[0][c] = 0

    for c in range(0, n, 1):
        d[0][c]= days[0][c]

    s, p = None, None
    for r in range (K):
        for c in range(1, n+1, 1):
            if c == 1:
                d[r][c] = d[c-1] [r]
            else:
                if c <= n-1 and flights[c-1][c] == 1:
                    d[r][c] = max(d[r][c], d[r-1][c-1] + days[r][c], d[r][c-1] + days[0][c-1], d[r-1][c] + days[r][c-1])
                else:
                    d[r][c] = max(d[r][c], d[r-1][c-1] + days[0][c], d[r][c-1] + days[0][c-1], d[r-1][c] + days[r][c-1])

                                   
    return d[K-1][n]




days = [[1, 3, 5],[6, 0, 3], [2, 4, 7]]
flights = [[0, 1, 1], [1, 0, 1], [1, 1, 0]]
ret = maxHolidays(days, flights)
