from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        l, r = 0, n - 1
        max_area = 0
        while l < r:
            area = (r - l) * min(height[l], height[r])
            max_area = max(max_area, area)
            if height[l] < height[r]:
                l += 1
            elif height[l] > height[r]:
                r -= 1
            elif height[l + 1] < height[r - 1]:
                r -= 1
            else:
                l += 1

        return max_area




