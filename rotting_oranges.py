from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rottens = set()
        freshes = set()
        n_rows = len(grid)
        n_cols = len(grid[0])
        for r, row in enumerate(grid):
            for c, o in enumerate(row):
                if o == 2:
                    rottens.add((r, c))
                elif o == 1:
                    freshes.add((r, c))

        drs = (0, 1, 0, -1)
        dcs = (1, 0, -1, 0)
        def fresh_neighbors(r, c):
            return [(r+dr, c+dc) for dr, dc in zip(drs, dcs) if (r+dr, c+dc) in freshes]

        n_fresh = len(freshes)

        minutes = 0

        def rot():
            diff = 0
            # breadth-fisrt-search
            for r, c in rottens.copy():
                for nr, nc in fresh_neighbors(r, c):
                    freshes.remove((nr, nc))
                    if (nr, nc) in rottens:
                        continue
                    rottens.add((nr, nc))
                    diff += 1
            return diff

        while True:
            diff = rot()
            if diff == 0:
                return minutes if n_fresh == 0 else -1

            n_fresh -= diff
            minutes += 1


