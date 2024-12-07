
class Solution:
    def isHappy(self, n: int) -> bool:
        so_far = set()
        while True:
            if n == 1:
                return True
            if n in so_far:
                return False
            so_far.add(n)
            n = sum([int(d)**2 for d in str(n)])

