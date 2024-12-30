class Solution:
    def minConnectedGroups(self, intervals: List[List[int]], k: int) -> int:
        intervals = sorted(intervals)
        gaps = []
        head, tail = intervals[0]
        for h, t in intervals:
            if h > tail:
                gaps.append((tail, h))
                tail = t
            else:
                tail = max(tail, t)
        
        ng = len(gaps)
        j = 0
        max_removal = 0
        for i, (h, _) in enumerate(gaps):
            while j <= ng-1 and gaps[j][1] - h <= k:
                j += 1
            max_removal = max(max_removal, j-i)

        return ng + 1 - max_removal

