from typing import List
from collections import defaultdict, deque


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        t_indices = defaultdict(deque)
        for i, t in enumerate(temperatures):
            t_indices[t].append(i)

        max_t = max(temperatures)
        ret = []
        for i, t in enumerate(temperatures):
            t_indices[t].popleft()

            nts = [nt for nt in range(t + 1, max_t + 1) if len(t_indices[nt]) > 0]
            if len(nts) == 0:
                ret.append(0)
                continue
            next_indices = [t_indices[nt][0] for nt in nts]
            ret.append(min(next_indices) - i)

        return ret


s = Solution()
print(s.dailyTemperatures([73,74,75,71,69,72,76,73]))

