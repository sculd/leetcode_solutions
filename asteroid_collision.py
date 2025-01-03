from typing import List

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        ret = []
        for v in asteroids:
            if v > 0:
                ret.append(v)
            else:
                destroyed = False
                while ret and ret[-1] > 0:
                    if ret[-1] > -v:
                        destroyed = True
                        break
                    elif ret[-1] == -v:
                        destroyed = True
                        ret.pop()
                        break
                    else:
                        ret.pop()
                if not destroyed:
                    ret.append(v)

        return ret


