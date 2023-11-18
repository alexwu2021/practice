
from typing import List
from collections import defaultdict
class ShortestCompletingWord:
    def shortestCompletingWord_okay(self, licensePlate: str, words: List[str]) -> str:

        licensePlate = ''.join([i.lower() for i in licensePlate if i.isalpha()])

        words = sorted(words, key=len) # it is a must
        for word in words:
            for i in range(len(licensePlate)):
                if word.count(licensePlate[i]) < licensePlate.count(licensePlate[i]):
                    break
                if i == len(licensePlate) - 1:
                    return word


licensePlate = "AN87005"
words = ["participant","individual","start","exist","above","already","easy","attack","player","important"]


licensePlate = "1s3 456"
words =["looks","pest","stew","show"]

actual = ShortestCompletingWord().shortestCompletingWord_okay(licensePlate, words)
print("actual: %s" % actual)





