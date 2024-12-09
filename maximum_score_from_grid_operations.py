from typing import List


class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        n = len(grid)

        transposed = list(zip(*grid))
        cumsums = [[0] * (n+1)]
        for col in transposed:
            cumsum = [0] * (n+1)
            for i, c in enumerate(col):
                cumsum[i+1] = cumsum[i] + c
            cumsums.append(cumsum)

        # until each column, then until each row
        last_excluded = [[0] * (n+1) for _ in range(n+1)]
        last_included = [[0] * (n+1) for _ in range(n+1)]

        for c in range(2, n+1):
            for r in range(n+1):
                for pr in range(n+1):
                    if r > pr:
                        last_excluded[c][r] = max(
                            last_excluded[c][r],
                            last_excluded[c-1][pr] + cumsums[c-1][r] - cumsums[c-1][pr])
                        last_included[c][r] = max(last_included[c][r], last_excluded[c][r])
                    else:
                        last_excluded[c][r] = max(last_excluded[c][r], last_included[c-1][pr])
                        last_included[c][r] = max(
                            last_included[c][r],
                            last_included[c-1][pr] + cumsums[c][pr] - cumsums[c][r])

        return max(last_included[n])


s = Solution()
grid = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]
#grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]

print(s.maximumScore(grid))

