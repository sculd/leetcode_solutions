from typing import List

class Match:
    def __init__(self, i: int, m: int, k: int):
        self.head_i = i
        self.i_delta = 0
        self.match_count = 0
        self.m = m
        self.k = k

    def check(self, arr: List[int], value: int) -> bool:
        if arr[self.head_i + self.i_delta] != value:
            return False
        self.i_delta += 1
        if self.i_delta >= self.m:
            self.match_count += 1
            self.i_delta = 0
        return True

    def is_complete(self) -> bool:
        return self.match_count == self.k


class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        matches = []
        for i, value in enumerate(arr):
            matches.append(Match(i, m, k))

            matches = [match for match in matches if match.check(arr, value)]
            completes = [match for match in matches if match.is_complete()]
            if len(completes) > 0:
                return True

        return False


s = Solution()

arr = [1,2,4,4,4,4]
m = 1
k = 3

print(s.containsPattern(arr, m, k))

