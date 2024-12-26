class SmallestInfiniteSet:

    def __init__(self):
        self.add_backs = set()
        self.smallest = 1

    def popSmallest(self) -> int:
        smallest = self.smallest
        if self.add_backs:
            smallest = min(self.add_backs)
            self.add_backs.remove(smallest)
        else:
            self.smallest += 1
        return smallest

    def addBack(self, num: int) -> None:
        if num >= self.smallest:
            return
        self.add_backs.add(num)

# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)