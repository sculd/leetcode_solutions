from typing import List
from collections import Counter

class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        cnts = Counter(nums)
        ret = 0
        for n1, c1 in cnts.items():
            n2 = k - n1
            if n1 > n2:
                continue

            if n1 == n2:
                ret += c1 // 2
                continue

            c2 = cnts.get(n2, 0)
            ret += min(c1, c2)

        return ret

s = Solution()
nums = [3,1,3,4,3]
k = 6
print(s.maxOperations(nums, k))

