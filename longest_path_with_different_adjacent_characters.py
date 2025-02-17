from typing import List
from collections import defaultdict

class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        neighbors = defaultdict(list)
        for c, p in enumerate(parent):
            if p == -1: continue
            neighbors[p].append(c)
            neighbors[c].append(p)

        longest = 0
        cached = {}

        def longest_path_with_one_branch(r: int, prev_n: int) -> int:
            cache_key = (r, prev_n)
            if cache_key in cached:
                return cached[cache_key]

            if r not in neighbors:
                return 1

            longest_from_connected_neighbors = []
            for n in neighbors[r]:
                if n == prev_n:
                    continue
                if s[r] == s[n]:
                    continue
                l = longest_path_with_one_branch(n, r)
                longest_from_connected_neighbors.append(l)

            longest_from_connected_neighbors.sort(reverse=True)
            l = 1 + sum(longest_from_connected_neighbors[:1])
            cached[cache_key] = l
            nonlocal longest
            longest = max(longest, l)
            return l


        def visit_all_children(r: int, prev_n: int):
            longest_from_connected_neighbors = []
            for n in neighbors[r]:
                if n == prev_n:
                    continue
                visit_all_children(n, r)
                if s[r] == s[n]:
                    continue
                l = longest_path_with_one_branch(n, r)
                longest_from_connected_neighbors.append(l)

            longest_from_connected_neighbors.sort(reverse=True)
            l = 1 + sum(longest_from_connected_neighbors[:2])
            nonlocal longest
            longest = max(longest, l)

        visit_all_children(0, -1)
        return longest


class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        children = defaultdict(list)
        for c, p in enumerate(parent):
            children[p].append(c)

        longest = 0
        longest_ending_at = defaultdict(int)

        def visit(node):
            nonlocal longest, longest_ending_at
            if not children[node]:
                longest = max(longest, 1)
                longest_ending_at[node] = 1
                return

            for c in children[node]:
                visit(c)

            cs = sorted([longest_ending_at[c] for c in children[node] if s[c] != s[node]])

            longest_ending_at[node] = sum(cs[-1:]) + 1
            longest = max(longest, sum(cs[-2:]) + 1)

        visit(0)
        return longest
    

sol = Solution()

#print(sol.longestPath([-1,0,0,1,1,2], "abacbe"))
#print(sol.longestPath([-1,0,0,0], "aabc"))
#print(sol.longestPath([-1,0,1], "aab"))
parent = [-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19]
s = "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal"
print(sol.longestPath(parent, s))

