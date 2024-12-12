from collections import defaultdict
import itertools
import functools

class Solution:
    @functools.cache
    def minDistance(self, w1: str, w2: str) -> int:
        if w1 in w2:
            return len(w2) - len(w1)
        elif w2 in w1:
            return len(w1) - len(w2)

        s1, s2 = set(w1), set(w2)

        if s1.isdisjoint(s2):
            return max(len(w1), len(w2))

        ch_indices1 = defaultdict(list)
        ch_indices2 = defaultdict(list)
        for i, c in enumerate(w1):
            ch_indices1[c].append(i)
        for i, c in enumerate(w2):
            ch_indices2[c].append(i)

        common_cs = s1.intersection(s2)
        dists = [max(len(w1), len(w2))]
        for c in common_cs:
            for i1, i2 in itertools.product(ch_indices1[c], ch_indices2[c]):
                dists.append(self.minDistance(w1[:i1], w2[:i2]) + self.minDistance(w1[i1 +1:], w2[i2 +1:]))

        return min(dists)


s = Solution()
print(s.minDistance(
    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
    "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"
))

