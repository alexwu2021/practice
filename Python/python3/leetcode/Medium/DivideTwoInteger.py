class DivideTwoIntegers:

    def divide(self, dividend: int, divisor: int) -> int:
        negative = (dividend < 0) ^ (divisor < 0)

        # there is a workaround, though not preferred way
        # positive = (dividend < 0) is (divisor < 0)


        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        while dividend >= divisor:
            curr_divisor, num_divisors = divisor, 1
            while dividend >= curr_divisor:
                dividend -= curr_divisor
                res += num_divisors
                curr_divisor = curr_divisor << 1
                num_divisors = num_divisors << 1

        if negative:
            res = -res
        return min(max(-2147483648, res), 2147483647)
