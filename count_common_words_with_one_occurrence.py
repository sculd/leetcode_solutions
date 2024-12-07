from typing import List

from collections import Counter

class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        if len(words2) > len(words1):
            words1, words2 = words2, words1

        r = 0
        cnts1 = Counter(words1)
        cnts2 = Counter(words2)

        for w1, c1 in cnts1.items():
            if c1 > 1: continue
            if w1 not in cnts2: continue
            if cnts2[w1] > 1: continue
            r += 1

        return r