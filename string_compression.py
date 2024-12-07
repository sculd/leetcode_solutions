from typing import List


class Solution:

    def compress(self, chars: List[str]) -> int:
        prev_ch = ""
        dup_count = 0
        wi = 0

        def write():
            if dup_count == 0:
                return
            nonlocal wi
            chars[wi] = prev_ch
            wi += 1
            if dup_count > 1:
                for dup_ch in str(str(dup_count)):
                    chars[wi] = dup_ch
                    wi += 1

        for ch in chars:
            if ch != prev_ch:
                # write prev ch
                write()
                dup_count = 1
            else:
                # write prev ch
                dup_count += 1

            prev_ch = ch

        # write current ch or prev ch
        if dup_count > 0:
            write()

        return wi


s = Solution()
#chars = ["a","a","b","b","c","c","c"]
chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
l = s.compress(chars)
print(chars[:l])