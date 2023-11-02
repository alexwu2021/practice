import random


class CountEven:
    def countEven(self, num):
        ans = 0
        temp = num
        while temp > 0:
            ans += temp % 10
            temp /= 10

        if ans % 2 == 0:
            return num // 2
        return (num - 1) // 2
        

    def countEven_hard_to_verify(self, num: int) -> int:
        def digit_sum(x):
            s = 0
            while x:
                x, r = divmod(x, 10)
                s += r
            return s % 2 == 0

        ans = num // 10 * 5 - 1
        for n in range(num // 10 * 10, num + 1):
            if digit_sum(n):
                ans += 1
        return ans

    def countEven_plain(self, num: int) -> int:
        def get_sum(n):
            m = 0
            while n > 0:
                m += (n % 10)
                n = n // 10
            return m
        ans = 0
        for n in range(2, num + 1):
            sm = get_sum(n)
            if sm % 2 == 0:
                ans += 1
        return ans

r = random.Random()
x = r.randint(2, 1000)
print("next run: %d" % x)
actual = CountEven().countEven(x)
actual2 = CountEven().countEven_plain(x)
assert(actual2 == actual)