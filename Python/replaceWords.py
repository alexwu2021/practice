class Solution:
    #accepted 
    def replaceWords(self, d, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        st = set(d)
        def findRoot(suc):
            for i in range(1, len(suc)):
                if suc[0:i] in st:
                    return suc[0:i]
            return None
        lst = [x.strip() for x in sentence.split(' ')]
        for j in range(0, len(lst)):
            findresult = findRoot(lst[j])
            if not findresult:
                continue
            else:
                lst[j] = findresult
            
        return ' '.join(lst)
