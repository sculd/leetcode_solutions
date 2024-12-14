from typing import List
from functools import cache


class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_or = 0
        for v in nums:
            max_or |= v

        l = len(nums)

        @cache
        def count(head, target):
            if target == 0:
                return 2 ** (l - head)

            if head == l:
                return 0

            nxt = target & (target ^ nums[head])
            return count(head + 1, target) + count(head + 1, nxt)

        return count(0, max_or)

s = Solution()
print(s.countMaxOrSubsets([3,1]))

