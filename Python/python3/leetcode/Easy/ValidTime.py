
# 2437. Number of Valid Clock Times
# number of ways with '?' in various places in a string of length 5, with ':' at the middle

import re
class ValidTime:
    def countTime(self, time: str) -> int:
        return sum(
            re.fullmatch(time.replace('?', '.'), f'{hour:02}:{minute:02}') is not None
            for hour in range(24)
            for minute in range(60)
        )

    def countTime2(self, time: str) -> int:
        mult = 1
        if time[-1] == '?': mult *= 10
        if time[-2] == '?': mult *= 6

        mult2 = 1
        if time[0] == '?' and time[1] == '?':
            mult2 *= 24
        elif time[0] == '?' and time[1] != '?':
            if int(time[1]) >= 4:
                mult2 *= 2
            else:
                mult2 *= 3

        elif time[0] != '?' and time[1] == '?':
            if int(time[0]) == 2:
                mult2 *= 4
            else:
                mult2 *= 10
        return mult * mult2





