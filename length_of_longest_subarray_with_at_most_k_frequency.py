from typing import List
from collections import defaultdict

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        cnts = defaultdict(int)

        longest = 0
        head = -1
        for tail, v in enumerate(nums):
            cnts[v] += 1
            while cnts[v] > k:
                head += 1
                cnts[nums[head]] -= 1

            longest = max(longest, tail - head)

        return longest


