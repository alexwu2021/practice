

def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        A_count = 0
        i = 0
        while i < len(s):
            if s[i] == 'A':
                A_count += 1
                if A_count > 1: #1 absence
                    return False
            elif s[i] == 'L':
                if i-2>=0 and s[i-2] == 'L' and s[i-1] == 'L': #three consective lates
                    return False
            i += 1
        return True
