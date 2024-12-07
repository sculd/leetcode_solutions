from typing import List

class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        edges_for_city = {c: 0 for c in range(n)}
        for road in roads:
            edges_for_city[road[0]] += 1
            edges_for_city[road[1]] += 1
        edges_sorted = sorted(edges_for_city.values())
        return sum([(rank + 1) * edges for rank, edges in enumerate(edges_sorted)])



s = Solution()


