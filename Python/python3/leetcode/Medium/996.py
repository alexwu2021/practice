def longestWPI(self, hours):
    ans = score = 0
    seen = {}
    for i, h in enumerate(hours):
        score = score + 1 if h > 8 else score - 1
        if score > 0:
            ans = i + 1
        seen.setdefault(score, i)
        if score - 1 in seen:
            ans = max(ans, i - seen[score - 1])
    return ans