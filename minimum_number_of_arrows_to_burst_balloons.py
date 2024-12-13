from typing import List

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points = sorted(points)
        tail = points[0][1]
        ret = 1
        for p in points:
            if p[0] <= tail:
                tail = min(tail, p[1])
            else:
                ret += 1
                tail = p[1]

        return ret

