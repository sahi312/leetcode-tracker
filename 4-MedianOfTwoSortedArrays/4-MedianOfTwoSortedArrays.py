# Last updated: 7/9/2026, 10:11:55 AM
class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        merged = []
        i = j = 0
        m, n = len(nums1), len(nums2)

        # Merge like in merge-sort
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        # Append leftovers
        while i < m:
            merged.append(nums1[i])
            i += 1
        while j < n:
            merged.append(nums2[j])
            j += 1

        length = m + n
        # Find median
        if length % 2 == 1:
            return float(merged[length // 2])
        else:
            return (merged[length // 2 - 1] + merged[length // 2]) / 2.0


        