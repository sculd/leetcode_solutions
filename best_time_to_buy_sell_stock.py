from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mp = 0
        cum_min = prices[0]
        for p in prices[1:]:
            cum_min = min(cum_min, p)
            if p - cum_min > mp:
                mp = p - cum_min

        return mp


s = Solution()

