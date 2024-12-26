from typing import List, Optional
from collections import defaultdict

class Node:
    def __init__(self, key: int = -1, val: int = -1, before=None, after=None):
        self.key = key
        self.val = val
        self.count = 0
        # later node in after
        self.before, self.after = before, after

def _remove(node):
    if node.before is None or node.after is None:
        return
    node.before.after = node.after
    node.after.before = node.before
    node.after, node.before = None, None

def _add_to_front(head, node):
    head.after, node.after = node, head.after
    node.before = head
    node.after.before = node

def _connect(node_before, node_after):
    node_before.after = node_after
    node_after.before = node_before


class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.n_entries = 0
        self.min_count = 1
        self.head_for_count = {}
        self.tail_for_count = {}
        self.node_dict = {}

    def _prepare_new_count(self, count):
        if count in self.head_for_count:
            return
        head, tail = Node(), Node()
        self.head_for_count[count] = head
        self.tail_for_count[count] = tail
        head.after, tail.before = tail, head

    def _clean_count(self, count):
        if count in self.head_for_count and \
                self.head_for_count[count].after == self.tail_for_count[count]:
            del self.head_for_count[count]
            del self.tail_for_count[count]
            return True
        return False

    def _increment_count(self, node):
        _remove(node)
        clount_cleaned = self._clean_count(node.count)

        node.count += 1
        if clount_cleaned and node.count - 1 == self.min_count:
            self.min_count = node.count

        self._prepare_new_count(node.count)
        _add_to_front(self.head_for_count[node.count], node)

    def get(self, key: int) -> int:
        if key not in self.node_dict:
            return -1
        node: Node = self.node_dict[key]
        self._increment_count(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key not in self.node_dict:
            if self.n_entries >= self.capacity:
                #lowest_cnt = sorted(self.tail_for_count.keys())[0]

                removed = self.tail_for_count[self.min_count].before
                _remove(removed)
                del self.node_dict[removed.key]
                self._clean_count(self.min_count)
                self.n_entries -= 1

            node = Node(key, value)
            self.node_dict[key] = node
            self.n_entries += 1
            self.min_count = 1

        node = self.node_dict[key]
        node.val = value
        self._increment_count(node)



# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


c = LFUCache(2)
c.put(1, 1)
c.put(2, 2)
print(c.get(1))
c.put(3, 3)
print(c.get(2))
print(c.get(3))
c.put(4, 4)
print(c.get(1))
print(c.get(3))
print(c.get(4))



# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

'''
[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
[[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

'''