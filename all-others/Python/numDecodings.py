def numDecodings(s):
    v, w, p = 0, int(s>''), ''
    print('v: %s; w:%s; p:%s' % (v, w, p))
    for d in s:
        v, w, p = w, ( d > '0' ) * w + ( 9 < int( p + d ) < 27 ) * v, d
        print('v: %s; w:%s; p:%s; d:%s' % (v, w, p, d))
    return w

s = '12'
res = numDecodings(s)
print('res: %d' % res)



#w tells the number of ways, of type int
#v tells the previous number of ways of type int
#d is the current digit, of type char
#p is the previous digit, of type char
