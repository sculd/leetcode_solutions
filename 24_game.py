from typing import List

def combine_value_value(v1: float, v2: float) -> List[float]:
    r = [v1 + v2, v1 - v2, v1 * v2]
    if v2 != 0:
        r.append(v1 / v2)
    return r

def combine_value_list(v1: float, vs_tail: List[float]) -> List[float]:
    return sum([combine_value_value(v1, v2) for v2 in vs_tail], [])

def combine_list_value(vs_head: List[float], v2: float) -> List[float]:
    return sum([combine_value_value(v1, v2) for v1 in vs_head], [])

def combine_list_list(vs_head: List[float], vs_tail: List[float]) -> List[float]:
    r = []
    for v1 in vs_head:
        for v2 in vs_tail:
            r += combine_value_value(v1, v2)
    return r

def permutate(vs: List[float]) -> List[List[float]]:
    if len(vs) <= 1:
        return [vs]
    if len(vs) == 2:
        return [vs, vs[::-1]]

    r = []
    for i in range(len(vs)):
        reordered = vs.copy()
        reordered[0], reordered[i] = reordered[i], reordered[0]
        tail_permutes = permutate(reordered[1:])
        r += [[reordered[0]] + tail for tail in tail_permutes]
    return r


class Solution:
    def length3(self, v1, v2, v3: float) -> List[float]:
        r = []
        r += combine_value_list(v1, combine_value_value(v2, v3))
        r += combine_list_value(combine_value_value(v1, v2), v3)
        return r

    def length4(self, cards: List[float]) -> List[float]:
        r = []
        r += combine_value_list(cards[0], self.length3(*cards[1:]))
        r += combine_list_value(self.length3(*cards[:3]), cards[3])

        vs_head = combine_value_value(*cards[:2])
        vs_tail = combine_value_value(*cards[2:])
        r += combine_list_list(vs_head, vs_tail)
        return r

    def judgePoint24(self, cards: List[int]) -> bool:
        def is_int_24(v: float) -> int:
            delta = 0.001
            iv = round(v)
            return iv == 24 and abs(v - iv) < delta

        for permuted in permutate(cards):
            vs = self.length4(permuted)
            if sum([is_int_24(v) for v in vs]) > 0:
                return True
        return False


s = Solution()
cards = [3,9,7,7]
print(s.judgePoint24(cards))

