# Last updated: 7/27/2026, 2:57:23 PM
1class Solution:
2    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
3
4        def convert(left, right):            
5            if left > right:
6                return
7
8            mid = (left + right) // 2
9
10            node = TreeNode(nums[mid])
11
12            node.left = convert(left, mid - 1)
13            node.right = convert(mid + 1, right)
14
15            return node
16        
17        return convert(0, len(nums) - 1)