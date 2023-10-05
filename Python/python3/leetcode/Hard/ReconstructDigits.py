from collections import Counter, defaultdict


class RecontructDigits:
    def originalDigits(self, s: str) -> str:

        def get_digit_dict(s):
            char_counter = Counter(s)
            ddict = defaultdict(int)


            # the following order matters, with evens going first
            ddict[0] = char_counter['z']

            # "w" only shows up in "two"
            ddict[2] = char_counter['w']

            # "u" only shows up in "four"
            ddict[4] = char_counter['u']

            # "x" only shows up in "six"
            ddict[6] = char_counter['x']

            # "g" only shows up in "eight"
            ddict[8] = char_counter['g']


            # "o" only shows up in "zero", "one", "two", "four"
            ddict[1] = char_counter['o'] - ddict[0] - ddict[2] - ddict[4]

            # "h" only shows up in "three", "eight"
            ddict[3] = char_counter['h'] - ddict[8]

            # "f" only shows up in "four", "five"
            ddict[5] = char_counter['f'] - ddict[4]

            # "s" only shows up in "six", "seven"
            ddict[7] = char_counter['s'] - ddict[6]

            # "i" only shows up in "five", "six", "eight", "nine"
            ddict[9] = char_counter['i'] - ddict[5] - ddict[6] - ddict[8]

            return ddict


        digit_dict = get_digit_dict(s)

        return "".join((str(d) * digit_dict[d]) for d in range(0, 10))

