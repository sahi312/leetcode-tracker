# Last updated: 7/9/2026, 10:12:00 AM
class Solution:
    def twoSum(self, nums, target):
        seen = {}  # dictionary to store value -> index
        for i, num in enumerate(nums):
            diff = target - num
            if diff in seen:
                return [seen[diff], i]
            seen[num] = i
