# Last updated: 7/9/2026, 10:07:33 AM
from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix = 0
        max_len = 0

        first_occurrence = {0: -1}

        for i, num in enumerate(nums):
            if num == 0:
                prefix -= 1
            else:
                prefix += 1

            if prefix in first_occurrence:
                max_len = max(max_len, i - first_occurrence[prefix])
            else:
                first_occurrence[prefix] = i

        return max_len