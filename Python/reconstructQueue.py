class Solution:
    #this one accepted
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people: return []

        peopledct, height, res = {}, [], []
        
        for i in range(len(people)):
            p = people[i]
            if p[0] in peopledct:
                peopledct[p[0]].append((p[1], i))
            else:
                peopledct[p[0]] = [(p[1], i)]
                height.append(p[0])

        height.sort() 
        for h in height[::-1]:
            peopledct[h].sort()
            for p in peopledct[h]:
                res.insert(p[0], people[p[1]])

        return res
        


s = Solution()
people = [[1,0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,0]]
people = [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

res = s.reconstructQueue(people)
print('res: %s; expecting: %s' % (res, [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]))
