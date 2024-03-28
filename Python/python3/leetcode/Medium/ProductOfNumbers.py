
from collections import defaultdict

class ProductOfNumbers:

    def __init__(self):
        self.stk = []
        self.mp = defaultdict(int)

    def add(self, num: int) -> None:
        self.stk.append(num)

    def getProduct(self, k: int) -> int:
        n = len(self.stk)

        if (n - k - 1, n - 1) in self.mp:
            return self.mp[(n - k-1, n - 1)]

        res = 1
        for i in range(n - 1, n - k - 1, -1):
            res *= self.stk[i]
        self.mp[(n - k - 1, n - 1)] = res
        return res



sol = ProductOfNumbers()
sol.add(1)
actual = sol.getProduct(1)
print(f"actual: {actual}")
actual = sol.getProduct(1)
print(f"actual: {actual}")

# ["ProductOfNumbers","add","getProduct","getProduct","getProduct","add","add","add"]