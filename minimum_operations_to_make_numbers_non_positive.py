from typing import List


class Solution:
    def minOperations(self, nums: List[int], x: int, y: int) -> int:
        def ceil(n, den):
            return (n + den - 1) // den

        nums = sorted(nums)
        ret = 0
        amount = 0
        for i in range(len(nums)):
            amount += nums[i]
            c = ceil(amount, x + y * i)
            ret = max(ret, c)

        return ret


s = Solution()
print(s.minOperations([3,4,1,7,6], 4, 2))


