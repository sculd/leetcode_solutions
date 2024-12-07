from typing import List
from collections import defaultdict

class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        if len(roads) == 0:
            return 0

        conns = defaultdict(set)
        for r in roads:
            conns[r[0]].add(r[1])
            conns[r[1]].add(r[0])

        conns_per_rank = defaultdict(list)

        for c, cs in conns.items():
            conns_per_rank[len(cs)].append((c, cs))

        top_ranks = sorted([rank for rank in conns_per_rank.keys()])[-2:][::-1]
        rank1 = top_ranks[0]
        if len(top_ranks) == 1 or len(conns_per_rank[rank1]) >= 2:
            for c1, cs1 in conns_per_rank[rank1]:
                for c2, _ in conns_per_rank[rank1]:
                    if c1 == c2: continue
                    if c2 not in cs1:
                        return rank1 * 2
            return rank1 * 2 - 1
        else:
            # only one top rank
            rank2 = top_ranks[1]
            c1, cs1 = conns_per_rank[rank1][0]
            for c2, _ in conns_per_rank[rank2]:
                if c2 not in cs1:
                    return rank1 + rank2

            return rank1 + rank2 - 1



