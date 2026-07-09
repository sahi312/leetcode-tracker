# Last updated: 7/9/2026, 10:07:22 AM
class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        delta = (sum(aliceSizes) - sum(bobSizes)) // 2
        aliceSizes = set(aliceSizes)
        for size in set(bobSizes):
            if delta + size in aliceSizes:
                return [delta + size, size]