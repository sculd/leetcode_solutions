from typing import List
from collections import defaultdict

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        outs, ins, conns = defaultdict(list), defaultdict(list), defaultdict(list)
        for c in connections:
            c1, c2 = c[0], c[1]
            outs[c1].append(c2)
            ins[c2].append(c1)
            conns[c1].append(c2)
            conns[c2].append(c1)

        visited = set()
        changes = 0
        dests = [0]
        while len(dests) > 0:
            new_dests = []
            for dest in dests:
                changes += len([o for o in outs[dest] if o not in visited])
                visited.add(dest)
                for conn in conns[dest]:
                    if conn in visited:
                        continue
                    new_dests.append(conn)

            dests = new_dests

        return changes

