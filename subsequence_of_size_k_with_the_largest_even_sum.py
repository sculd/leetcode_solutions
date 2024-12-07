from typing import List
from collections import Counter, defaultdict


class Solution:
    def largestEvenSum(self, nums: List[int], k: int) -> int:
        evens = sorted([v for v in nums if v % 2 == 0], reverse=True)
        odds = sorted([v for v in nums if v % 2 == 1], reverse=True)

        even_sums = []
        o = 0
        while True:
            if k-o < 0 or o > len(odds):
                break

            if k-o > len(evens):
                o += 2
                continue

            even_sums.append(sum(evens[:k-o]) + sum(odds[:o]))
            o += 2

        return -1 if len(even_sums) == 0 else max(even_sums)


s = Solution()
nums = [4,6,2]
k = 3
print(s.largestEvenSum(nums, k))

