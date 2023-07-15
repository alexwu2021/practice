class Solution:
    #accepted
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = ['a','e', 'i','o', 'u']
        vwls = []
        for ch in s:
            if ch.lower() in vowels:
                vwls.append(ch)
        vwls = vwls[::-1]
        j = 0
        lst = [x for x in s]
        for i in range(len(lst)):
            if lst[i].lower() in vowels:
                lst[i] = vwls[j]
                j += 1
        return ''.join(lst)
    
    
