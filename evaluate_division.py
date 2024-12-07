from typing import List

from collections import defaultdict


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        edges = defaultdict(dict)
        for i, eq in enumerate(equations):
            a, b = eq
            edges[a][b] = values[i]
            edges[b][a] = 1. / values[i]

        def find(search, goal, visited, val):
            if search not in edges or goal not in edges:
                return -1

            if search == goal:
                return val

            new_visited = visited.copy()
            new_visited.add(search)
            for neighbor in edges[search]:
                if neighbor in visited: continue
                f = find(neighbor, goal, new_visited, val * edges[search][neighbor])
                if f != -1.0:
                    return f
            return -1.0

        return [find(search=a, goal=b, visited=set(), val=1.0) for a, b in queries]




