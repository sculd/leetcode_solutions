from typing import List


class Solution:
    def minimumTime(self, nums1: List[int], nums2: List[int], x: int) -> int:
        nums1, nums2 = zip(*sorted(zip(nums1, nums2), key=lambda p: p[1]))
        sum1, sum2 = sum(nums1), sum(nums2)
        n = len(nums1)

        dp = [0 for i in range(n + 1)]
        j = 0
        while True:
            if j > n:
                return -1
            if sum1 + sum2 * j - dp[n] <= x:
                return j
            prev_dp = dp.copy()
            dp[0] = 0
            j += 1
            for i in range(1, n + 1):
                dp[i] = max(dp[i - 1], prev_dp[i - 1] + nums1[i - 1] + nums2[i - 1] * j)



nums1, nums2 = [1,2,3], [1,2,3]
x = 4
s = Solution()
print(s.minimumTime(nums1, nums2, x))
