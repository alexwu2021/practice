class BaseNeg2:
    def baseNeg2(self, n: int) -> str:
        result = ""
        while n != 0:
            rem = n % -2
            n //= -2
            if rem < 0:
                rem += 2
                n += 1
            result = str(rem) + result
        return max(result, str("0"))
