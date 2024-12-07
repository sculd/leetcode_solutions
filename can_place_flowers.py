from typing import List

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        fl = 0
        zeroes = 0
        for p in flowerbed:
            if p == 0:
                zeroes += 1
            else:
                if zeroes > 0:
                    fl += (zeroes - 1) // 2
                zeroes = 0
        fl += zeroes // 2
        return fl >= n

s = Solution()
print(s.canPlaceFlowers([1,0,0,0,1], 2))



