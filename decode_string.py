class Solution:
    def decodeString(self, s: str) -> str:
        ret = ""
        repeats = []
        words = []

        repeats.append("1")
        words.append("")
        is_counting = False

        for i, c in enumerate(s):
            if c in "0123456789":
                if not is_counting:
                    repeats.append("")
                    words.append("")
                    is_counting = True
                repeats[-1] += c
            elif c == "[":
                is_counting = False
            elif c == "]":
                a = int(repeats.pop()) * words.pop()
                words[-1] += a
            else:
                words[-1] += c

        return words[-1]

