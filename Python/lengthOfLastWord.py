class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s is None: return 0
        ln = len(s)
        if ln <= 0: return 0
       
        
        #rule out all the white spaces
        i = ln -1
        while i >= 0 and s[i] == ' ':
            i -= 1
        if i< 0: #cannot use equal to zero here
            return 0
        
        #from j to i is the length of the last word
        j = i
        while j >= 0 and s[j] != ' ':
            j -= 1
            
        return i - j
        
