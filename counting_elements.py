from typing import List

class Solution:
    def countElements(self, arr: List[int]) -> int:
        vs = set(arr)
        return len([v for v in arr if v+1 in vs])


s = Solution()

