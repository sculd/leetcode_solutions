class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        diff: int = (a | b) ^ c
        remove_a: int = diff & a
        remove_b: int = diff & b
        add: int = (remove_a | remove_b) ^ diff
        ret: int = 0
        while remove_a or remove_b or add:
            ret += 1 if (remove_a % 2 == 1) else 0
            ret += 1 if (remove_b % 2 == 1) & 1 else 0
            ret += 1 if (add % 2 == 1) & 1 else 0
            remove_a >>= 1
            remove_b >>= 1
            add >>= 1
        
        return ret

