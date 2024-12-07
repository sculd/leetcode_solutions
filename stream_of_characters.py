from typing import List

class GrowingTrie:
    def __init__(self, word: str):
        self.word = word
        self.i = 0

    def is_complete(self):
        return self.i == len(self.word)

    def match(self, letter: str):
        if self.i >= len(self.word) or letter != self.word[self.i]:
            return False
        self.i += 1
        return True


class InitTrie:
    def __init__(self, word: str):
        self.word = word

    def create_growing_trie(self, letter: str):
        if letter != self.word[0]:
            return None
        return GrowingTrie(self.word)


class StreamChecker:
    def __init__(self, words: List[str]):
        self.init_tries = []
        for word in words:
            self.init_tries.append(InitTrie(word))
        self.growing_tries = []

    def query(self, letter: str) -> bool:
        for it in self.init_tries:
            gt = it.create_growing_trie(letter)
            if gt is None: continue
            self.growing_tries.append(gt)

        self.growing_tries = [gt for gt in self.growing_tries if gt.match(letter)]
        n_gts = len(self.growing_tries)
        self.growing_tries = [gt for gt in self.growing_tries if not gt.is_complete()]
        return len(self.growing_tries) < n_gts


# Your StreamChecker object will be instantiated and called as such:
obj = StreamChecker(["cd","f","kl"])

letters = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"]
for l in letters:
    print(f"{l=} {obj.query(l)}")


