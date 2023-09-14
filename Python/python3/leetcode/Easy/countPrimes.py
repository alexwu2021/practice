class Solution:
    #accepted. this one definitely works, but i have problem understanding it
    def countPrimes(self, n):
        if n < 3:
            return 0
        primes = [True] * n
        primes[0] = primes[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if primes[i]:
                primes[i * i: n: i] = [False] * len(primes[i * i: n: i]) #the marked line, I need explain this
        return sum(primes)


#a prime number k will be utilized to mark off those which are multiples of the given k
#2 ---> 4,6,8,10,12,14 ... 100
#which makes prime[4] =False, prime[6]=False, prime[8]=False....
#3 -- > 9,12,15,18,21,24... 96, 99

    
    #this one borrowed from discuss, and does not work    
    def countPrimes2(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 0

        primes = [True] * n
        primes[0] = primes[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if primes[i]:
                for j in range(i * i, n, i): #this is the wrong way, why???
                    primes[j] = False
            return sum(primes)

s = Solution()
res = s.countPrimes2(10000)  #1229
print(res)
