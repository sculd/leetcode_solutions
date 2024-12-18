from typing import List

class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX != rootY:
                parent[rootX] = rootY

        n = len(row) // 2
        parent = [i for i in range(n)]

        for i in range(0, len(row), 2):
            union(row[i] // 2, row[i+1] // 2)

        count = sum([1 for i, x in enumerate(parent) if i == find(x)])
        return n - count

s = Solution()
print(s.minSwapsCouples([0,5,2,1,4,3]))
