import os,sys,unittest


def numDecode(s):
    if s is None or len(s) <= 0:
        return 0
    n = len(s)
    d = [0] * (n + 1)
    d[n] = 1
    if s[n-1] != '0' and str(s[n-1]).isdigit():
        d[n-1] = 1
    for i in range(n-2, -1, -1):
        if str(s[i:i+2]).isdigit() and int(s[i:i+2]) <= 26:
            d[i] = d[i+1] + d[i+2]
        else:
            d[i] = d[i+1]
    return d[0]


s = '12325'
res = numDecode(s)
print (res)
