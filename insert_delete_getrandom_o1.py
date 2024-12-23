import random

class RandomizedSet:

    def __init__(self):
        self.vals = []
        self.pos = {}


    def insert(self, val: int) -> bool:
        if val in self.pos:
            return False

        self.pos[val] = len(self.vals)
        self.vals.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.pos:
            return False

        val_tail = self.vals[-1]
        p = self.pos[val]
        self.vals[p] = val_tail
        self.pos[val_tail] = p
        del self.pos[val]
        self.vals.pop()

        return True

    def getRandom(self) -> int:
        r = random.randint(1, len(self.vals))
        return self.vals[ r -1]



# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()