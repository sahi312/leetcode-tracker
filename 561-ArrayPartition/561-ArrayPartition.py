# Last updated: 7/9/2026, 10:07:32 AM
from typing import List

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        return sum(nums[::2])