from collections import defaultdict
from typing import List
import math


class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        conns = defaultdict(list)
        n = 0
        for r in roads:
            conns[r[0]].append(r[1])
            conns[r[1]].append(r[0])
            n = max(n, *r)
        n += 1

        cities_at = defaultdict(list)
        city_dists = {}

        def visit(dest, source, dist):
            cities_at[dist].append(dest)
            city_dists[dest] = dist
            for c in conns[dest]:
                if c == source:
                    continue
                visit(c, dest, dist + 1)

        visit(0, -1, 0)
        dists = sorted(cities_at.keys())[::-1]

        cost = 0
        pasengers_at = {city: 1 for city in range(n)}

        def depart(city):
            if city == 0:
                return
            next_city = sorted(conns[city], key=lambda c: city_dists[c])[0]
            pasengers_at[next_city] += pasengers_at[city]
            cars = math.ceil(pasengers_at[city] / seats)
            nonlocal cost
            cost += cars

        for dist in dists:
            for city in cities_at[dist]:
                depart(city)

        return cost


s = Solution()
print(s.minimumFuelCost([[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], 2))

