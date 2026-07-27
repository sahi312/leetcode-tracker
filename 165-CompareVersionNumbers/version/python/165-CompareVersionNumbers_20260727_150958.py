# Last updated: 7/27/2026, 3:09:58 PM
1class Solution:
2    def majorityElement(self, nums: List[int]) -> int:
3        nums.sort()
4        n = len(nums)
5        return nums[n//2]