from typing import List
import collections
import bisect

# 1488

class AvoidFlood:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        ans, dry_days = [], []
        full_lakes = collections.defaultdict(list)
        for i, rain in enumerate(rains):
            if rain == 0:
                dry_days.append(i)  # dry day indices
                ans.append(1)
            else:
                if len(full_lakes[rain]) >= 1:
                    if not dry_days:
                        return [] # doomed to flood

                    to_be_dried = full_lakes[rain].pop()  # candidate for drying up
                    j = bisect.bisect(dry_days, to_be_dried)  # locate the first available element in dry_days

                    if j == len(dry_days):
                        return []  # if we have no available dry_days, return []
                    ans[dry_days[j]] = rain  # record in the answer, that is our action for that lake
                    dry_days.pop(j)
                    full_lakes[rain].append(i)
                    ans.append(-1)
                else:
                    full_lakes[rain].append(i)
                    ans.append(-1)
        return ans