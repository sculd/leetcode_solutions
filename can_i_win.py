from typing import List
import bisect


class Solution:
    def __init__(self):
        self.result = {}

    def can_win(self, choosables: List[int], desired: int) -> bool:
        if sum(choosables) < desired:
            return False

        if bisect.bisect_left(choosables, desired) < len(choosables):
            return True

        for i in range(len(choosables)):
            new_choosables = choosables[:i] + choosables[i + 1:]
            if not self.can_win_cached(new_choosables, desired - choosables[i]):
                return True
        return False

    def can_win_cached(self, choosables: List[int], desired: int) -> bool:
        k = (tuple(choosables), desired)
        if k not in self.result:
            r = self.can_win(choosables, desired)
            self.result[k] = r
            return r
        return self.result[k]

    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        return self.can_win_cached([i for i in range(1, maxChoosableInteger + 1)], desiredTotal)


s = Solution()
maxChoosableInteger = 5
desiredTotal = 50
print(s.canIWin(maxChoosableInteger, desiredTotal))



