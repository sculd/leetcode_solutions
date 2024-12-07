class Node:
    def __init__(self, key: int, val: int, before=None, after=None):
        self.key = key
        self.val = val
        self.before, self.after = before, after


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.before, self.tail.after = self.tail, self.head
        self.nodes = {}

    def _remove(self, node):
        node.before.after = node.after
        node.after.before = node.before
        node.after, node.before = None, None
        self.capacity += 1

    def _trim_tail(self):
        while self.capacity < 0:
            node = self.tail.after
            self._remove(node)
            del self.nodes[node.key]

    def _add_to_front(self, node):
        node.after = self.head
        node.before = self.head.before
        node.before.after = node
        self.head.before = node
        self.capacity -= 1

    def get(self, key: int) -> int:
        if key not in self.nodes:
            return -1
        node = self.nodes[key]
        self._remove(node)
        self._add_to_front(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.nodes:
            node = self.nodes[key]
            self._remove(node)
        else:
            node = Node(key, value)
            self.nodes[key] = node
        self._add_to_front(node)
        node.val = value
        self._trim_tail()

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

c = LRUCache(2)
c.put(2, 1)
c.put(2, 2)
print(c.get(2))
c.put(1, 1)
c.put(4, 1)
print(c.get(2))



