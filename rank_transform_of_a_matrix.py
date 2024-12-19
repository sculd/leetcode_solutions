from typing import List
from collections import defaultdict
import itertools



class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        n, m = len(matrix), len(matrix[0])
        row_rank = [0 for _ in range(n)]
        col_rank = [0 for _ in range(m)]
        rank = [0 for _ in range(n+m)]
        matrix_rank = [[0 for _ in range(m)] for _ in range(n)]

        val_pos = defaultdict(list)
        for r, c in itertools.product(range(n), range(m)):
            val_pos[matrix[r][c]].append((r,c))

        def find(i):
            if p[i] != i:
                p[i] = find(p[i])
            return p[i]

        def union(i, j):
            fi, fj = find(i), find(j)
            if fi != fj:
                p[i] = fj

        val_pos_sorted = sorted(val_pos)
        for v in val_pos_sorted:
            p = list(range(n+m))

            rank_for_val = rank.copy()
            for r, c in val_pos[v]:
                fr, fc = find(r), find(c + n)
                union(fr, fc)
                f = find(r)
                rank_for_val[f] = max(rank_for_val[fr], rank_for_val[fc])

            # update rank based on rank_for_val
            for r, c in val_pos[v]:
                f = find(r)
                nr = rank_for_val[f] + 1
                rank[r] = rank[n+c] = nr
                matrix_rank[r][c] = nr

        return matrix_rank


s = Solution()
mm = s.matrixRankTransform([[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]])
for rs in mm:
    print(rs)


