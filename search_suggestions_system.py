from collections import defaultdict
from typing import List

class Node:
    def __init__(self):
        self.products = []
        self.nexts = defaultdict(Node)


class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        nexts = defaultdict(Node)

        for p in products:
            p_nexts = nexts
            for ch in p:
                p_nexts[ch].products.append(p)
                p_nexts = p_nexts[ch].nexts

        ret = []
        s_nexts = nexts
        for sc in searchWord:
            node = s_nexts[sc]
            ret.append(sorted(node.products)[:3])
            s_nexts = node.nexts

        return ret
