from typing import List

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals)
        prev_tail = intervals[0][0]
        ret = 0
        for i in intervals:
            if i[0] < prev_tail:
                ret += 1
                prev_tail = min(prev_tail, i[1])
            else:
                prev_tail = i[1]

        return ret

s = Solution()
print(s.eraseOverlapIntervals([[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]))




