def minDeletionSize(self, A):
        return sum(list(col) != sorted(col) for col in zip(*A))