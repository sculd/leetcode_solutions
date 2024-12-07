from collections import Counter, defaultdict

def choose_from_head(head: str, tail: str):
    ch_choice = sorted(head)[0]

    for i, ch in enumerate(head):
        if ch == ch_choice:
            # losers are chosen later
            new_tail = head[i + 1:] + tail
            new_tail = new_tail.replace(ch_choice, "")
            return ch_choice, new_tail

def choose_one_front_letter(s: str):
    cnts = Counter(s)
    running_cnts = defaultdict(int)
    for i, c in enumerate(s):
        running_cnts[c] += 1
        # seen all occurance of c, must choose now
        if cnts[c] == running_cnts[c]:
            head, tail = s[:i+1], s[i+1:]
            return choose_from_head(head, tail)

    return choose_from_head(s, "")

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        ret = ""
        while True:
            # head has no duplicate now.
            choice, s = choose_one_front_letter(s)
            ret += choice
            if len(s) == 0:
                break
        return ret



s = Solution()
print(s.removeDuplicateLetters("bbcaac"))



