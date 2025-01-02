from typing import List
from itertools import pairwise


class Solution:

    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)

        max_i = None
        min_j = None
        for j in range(1, n):
            if arr[j - 1] > arr[j]:
                max_i = j - 1 if max_i is None else max_i
                min_j = j

        if max_i is None:
            return 0

        shortest = min_j
        # i is last head, j is first tail, subarray is i+1 to j, of length j-i-1
        i, j = 0, min_j

        while True:
            if j == n or arr[i] <= arr[j]:
                shortest = min(shortest, j - i - 1)
                i += 1
            else:
                j += 1

            if i > max_i:
                break

        return shortest


s = Solution()
arr = [5, 4, 3, 2, 1]
print(s.findLengthOfShortestSubarray(arr))

