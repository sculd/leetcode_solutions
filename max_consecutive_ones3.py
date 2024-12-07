from typing import List


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        def compress(nums: List[int]):
            ozcs = []
            ones = 0
            zeroes = 0
            on_zeroes = True
            for v in nums:
                if on_zeroes and v == 1:
                    ozcs.append((ones, zeroes))
                    ones = 1
                    zeroes = 0
                    on_zeroes = False
                elif on_zeroes and v == 0:
                    zeroes += 1
                elif not on_zeroes and v == 0:
                    zeroes = 1
                    on_zeroes = True
                elif not on_zeroes and v == 1:
                    ones += 1
            ozcs.append((ones, zeroes))
            return ozcs

        def get_longest(compressed):
            longest = 0
            for i in range(len(compressed)):
                length = 0
                j = i
                kv = k
                while True:
                    if j >= len(compressed):
                        break
                    ones, zeroes = compressed[j]
                    length += ones
                    if kv >= zeroes:
                        j += 1
                        kv -= zeroes
                        length += zeroes
                    else:
                        length += kv
                        break
                longest = max(longest, length)
            return longest

        return max(get_longest(compress(nums)), get_longest(compress(nums[::-1])))


nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
k = 3
s = Solution()
#print(s.longestOnes(nums, k))
print(s.longestOnes([1,1,1,0,0,0,1,1,1,1,0], 2))

