
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        cache = {}
        def cache_and_return(k, v):
            nonlocal cache
            cache[k] = v
            return v

        def fn(n, k):
            cache_key = (n, k)
            if cache_key in cache:
                return cache[cache_key]

            """Return min moves given n floors and k eggs."""
            if k == 1: return cache_and_return(cache_key, n)
            if n == 0: return cache_and_return(cache_key, 0)
            lo, hi = 1, n + 1
            while lo < hi:
                mid = lo + hi >> 1
                # lower vs upper
                if fn(mid - 1, k - 1) < fn(n - mid, k):
                    # upper
                    lo = mid + 1
                else:
                    # lower
                    hi = mid
            r = 1 + max(fn(lo - 1, k - 1), fn(n - lo, k))
            return cache_and_return(cache_key, r)


        return fn(n, k)


s = Solution()
print(s.superEggDrop(2, 6))



