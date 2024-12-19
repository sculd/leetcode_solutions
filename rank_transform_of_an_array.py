from typing import List


class Solution:
    def arrayRankTransform2(self, arr: List[int]) -> List[int]:
        ranks = {v: i for i, v in enumerate(sorted(set(arr)))}
        return [ranks[v] + 1 for v in arr]

    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        ordered = sorted([(v, i) for i, v in enumerate(arr)])
        ret = [0 for _ in range(len(arr))]
        cur_r = 0
        prev_v = None
        for v, i in ordered:
            if v != prev_v:
                cur_r += 1
            ret[i] = cur_r
            prev_v = v

        return ret


s = Solution()
print(s.arrayRankTransform([37,12,28,9,100,56,80,5,12]))

