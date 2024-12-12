import bisect
from collections import defaultdict


class StockSpanner:

    def __init__(self):
        self.v_indices = defaultdict(int)
        self.day = 0

    def next(self, price: int) -> int:
        vs_sorted = sorted(self.v_indices.keys())
        i = bisect.bisect_right(vs_sorted, price)
        recent_day = max([self.v_indices[v] for v in vs_sorted[i:]], default=-1)

        self.v_indices[price] = self.day
        self.day += 1

        return self.day - recent_day - 1



s = StockSpanner()
for p in [31, 41, 48, 59, 79]:
    print(s.next(p))

