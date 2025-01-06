from typing import List

class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        shifts = sorted(shifts)
        
        n = len(s)
        ds = [0 for _ in s]
        tails = []
        dcum = 0
        prevh = 0
        for shift in shifts:
            h, t, d = shift
            d = d * 2 - 1

            if h > prevh:
                for i in range(prevh, h):
                    ds[i] = dcum
                    while tails and tails[0][0] == i:
                        dcum -= heapq.heappop(tails)[1]

            prevh = h
            dcum += d
            heapq.heappush(tails, (t, d))

        for i in range(prevh, n):
            ds[i] = dcum
            while tails and tails[0][0] == i:
                dcum -= heapq.heappop(tails)[1]


        cl = [c for c in s]
        ord_a = ord('a')
        for i, d in enumerate(ds):
            cl[i] = chr((ord(cl[i]) + 26 + d - ord_a) % 26 + ord_a)

        return ''.join(cl)



