from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        one = [0] * (n + 1)

        max_p = prices[-1]
        for i, p in enumerate(prices[::-1]):
            one[n-1-i] = max(one[n-i], max_p - p)
            max_p = max(max_p, p)

        mp = 0
        min_p = prices[0]
        for i, p in enumerate(prices):
            mp = max(mp, p - min_p + one[i])
            min_p = min(min_p, p)
        return mp

s = Solution()
print(s.maxProfit([3,3,5,0,0,3,1,4]))

