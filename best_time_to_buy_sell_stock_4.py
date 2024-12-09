from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        # tuple for while in position False and True
        costs = [ prices[0] ] * (k+1)
        assets = [0] * (k+1)

        for p in prices:
            # t for transactions
            for t in range(1, k+1):
                costs[t] = min(costs[t], p - assets[t-1])
                assets[t] = max(assets[t], p - costs[t])

        return assets[k]



s = Solution()
print(s.maxProfit(2, [2,4,1]))




