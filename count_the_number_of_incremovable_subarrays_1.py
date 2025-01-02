from typing import List
from itertools import pairwise

class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        cnt = 0
        n = len(nums)
        for i in range(n):
            for j in range(i, n):
                arr = nums[:i] + nums[j + 1:]
                cnt += all([v1 < v2 for v1, v2 in pairwise(arr)])

        return cnt


