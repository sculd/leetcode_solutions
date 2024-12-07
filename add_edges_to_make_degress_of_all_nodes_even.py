from typing import List
from collections import defaultdict

class Solution:
    def isPossible(self, n: int, edges: List[List[int]]) -> bool:
        neighbors = defaultdict(set)
        for a, b in edges:
            neighbors[a].add(b)
            neighbors[b].add(a)

        with_odd_neighbors = [i for i in range(1, n+1) if len(neighbors[i]) % 2 == 1]
        def is_possible_by_one_edge(a, b):
            return a != b and b not in neighbors[a]

        if len(with_odd_neighbors) == 2:
            a, b = with_odd_neighbors
            if is_possible_by_one_edge(a, b):
                return True
            for i in range(1, n+1):
                if i not in neighbors[a] and i not in neighbors[b]:
                    return True
        elif len(with_odd_neighbors) == 4:
            a, b, c, d = with_odd_neighbors
            return is_possible_by_one_edge(a, b) and is_possible_by_one_edge(c, d) \
                or is_possible_by_one_edge(a, c) and is_possible_by_one_edge(b, d) \
                or is_possible_by_one_edge(a, d) and is_possible_by_one_edge(b, c)

        return len(with_odd_neighbors) == 0


s = Solution()

n = 5
edges = [[1,2],[3,4],[4,5],[3,5]]
print(s.isPossible(n, edges))


