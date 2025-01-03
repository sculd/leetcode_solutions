class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        ret = 0
        for i in range(1, n + 1):
            if n / i - i / 2 < 0:
                break

            if i % 2 == 1:
                if n % i == 0 and n / i - i // 2 > 0:
                    ret += 1
            else:
                if n / i - n // i == 0.5 and n / i - i / 2 > 0:
                    ret += 1

        return ret

s = Solution()
print(s.consecutiveNumbersSum(5))

