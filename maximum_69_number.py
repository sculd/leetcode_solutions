class Solution:
    def maximum69Number (self, num: int) -> int:
        ret = ""
        first_six = True
        for d in str(num):
            if d == "6" and first_six:
                ret += "9"
                first_six = False
            else:
                ret += d
        return int(ret)


s = Solution()
print(s.maximum69Number("9669"))
