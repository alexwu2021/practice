class Solution:
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ret = []
        size = len(s)
        if size < 4 :
            return ret
       
            
        
        
    def restoreIpAddressesHelper(self, r, stringSoFar, ret, level):
        if level == 4:
            if int(r) <= 255:
                ret.appeend(r + '.' + stringSoFar)
            else: #bad branch to trim
                return
        
        if len(r) <= 0:
            return
        
        
        
        t = s[size - 3:]
        nTrailing = int(r)
        
        possible = []
        if nTrailing <= 255:
            possible.append(nTrailing % 10)
            possible.append(nTrailing % 100)
            possible.append(nTrailing % 256)
            r = s[size -3: ]
        elif nTrailing > 255:
            possible.append(nTrailing % 10)
            possible.append(nTrailing % 100)
            r = s[size -2:]
        self.restoreIpAddressesHelper(r, possible, ret, 2)
        
        
