from typing import List
from collections import defaultdict


from collections import deque

def topologicalSort(nodes, pred, succ):
    nodes_set = set(nodes)
    pred = defaultdict(set, {n: nodes_set.intersection(ps) for n, ps in pred.items()})
    succ = defaultdict(set, {n: nodes_set.intersection(ss) for n, ss in succ.items()})
    order, no_pred = [], deque(node for node in nodes if not pred[node])
    while no_pred:
        node = no_pred.popleft()
        order.append(node)
        for s in succ[node]:
            pred[s].discard(node)
            if not pred[s]:
                no_pred.append(s)
    return order if len(order) == len(nodes) else []


def sort_within(n, vs, befores):
    ranks = {v: 0 for v in vs}

    def ensure_rank_orders(p, v):
        befores_with_ranks = [b for b in befores[v] if b in ranks]
        updated = False
        # before (aka required) should have higher rank.
        for b in befores_with_ranks:
            if ranks[v] + 1 > ranks[b]:
                ranks[b] = ranks[v] + 1
                updated = True

        return updated

    cnt = 0
    while True:
        updated = sum([ensure_rank_orders(-1, v) for v in vs]) > 0
        if not updated:
            break
        cnt += 1
        if cnt > n:
            return []

    return [rv[1] for rv in sorted([(-rank, v) for v, rank in ranks.items()])]


class Solution:
    def sortItems(self, n: int, m: int, group: List[int], beforeItems: List[List[int]]) -> List[int]:
        group_members = defaultdict(set)
        person_to_group = {}
        nc = 0
        for i, g in enumerate(group):
            if g == -1:
                g = -1 - nc
                group[i] = g
                nc += 1
            group_members[g].add(i)
            person_to_group[i] = g

        before_items = defaultdict(set)
        after_items = defaultdict(set)
        before_groups = defaultdict(set)
        after_groups = defaultdict(set)
        for i, bs in enumerate(beforeItems):
            for b in bs:
                if person_to_group[i] == person_to_group[b]:
                    before_items[i].add(b)
                    after_items[b].add(i)
                else:
                    before_groups[person_to_group[i]].add(person_to_group[b])
                    after_groups[person_to_group[b]].add(person_to_group[i])

        group_ordered = topologicalSort(group_members.keys(), before_groups, after_groups)
        if len(group_ordered) == 0:
            return []

        ret = []
        for g in group_ordered:
            members_orderd = topologicalSort(group_members[g], before_items, after_items)
            if len(members_orderd) == 0:
                return []
            ret += members_orderd

        return ret


s = Solution()
print(s.sortItems(8, 2,
                  [-1,-1,1,0,0,1,0,-1],
                  [[],[6],[5],[6],[3,6],[],[],[]],
                  ))
