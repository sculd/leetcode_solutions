import bisect

l = [1, 3, 10, 17]

i_left = bisect.bisect_left(l, 10)
i_right = bisect.bisect_right(l, 10)

print(f"{bisect.bisect_left([], 10)=}")
print(f"{i_left=} {i_right=}")

nums1, nums2 = [1,2,3], [1,2,3]
nums1, nums2 = zip(*sorted(zip(nums1, nums2), key=lambda p: p[1]))
print(nums1, nums2)

print('done')



