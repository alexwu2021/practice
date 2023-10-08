# 408. Valid Word Abbreviation


class ValidAbbreviation:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i, j = 0, 0
        while i < len(word) and j < len(abbr):
            if not abbr[j].isdigit():
                if word[i] != abbr[j]:
                    return False
                i += 1
                j += 1
            else:
                # find out the skip length
                skip = 0
                while j < len(abbr) and abbr[j].isdigit():
                    if skip == 0 and abbr[j] == '0':
                        return False
                    skip = skip * 10 + int(abbr[j])
                    j += 1
                i += skip

        return i == len(word) and j == len(abbr)