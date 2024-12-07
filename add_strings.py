from typing import List

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        num1, num2 = num1[::-1], num2[::-1]
        i = 0
        carry = 0
        total = ""
        while True:
            if i >= len(num1) and i >= len(num2):
                break
            v1 = int(num1[i]) if i < len(num1) else 0
            v2 = int(num2[i]) if i < len(num2) else 0

            digit_sum = v1 + v2 + carry
            s = digit_sum % 10
            carry = digit_sum // 10
            total += str(s)
            i += 1
        if carry > 0:
            total += str(carry)
        return total[::-1]
