# Last updated: 7/27/2026, 2:56:39 PM
1# Definition for a binary tree node.
2# class TreeNode(object):
3#     def __init__(self, val=0, left=None, right=None):
4#         self.val = val
5#         self.left = left
6#         self.right = right
7from collections import deque
8
9class Solution(object):
10    def levelOrderBottom(self, root):
11        if not root:
12            return []
13
14        result = []
15        queue = deque([root])
16
17        while queue:
18            level = []
19            for _ in range(len(queue)):
20                node = queue.popleft()
21                level.append(node.val)
22                if node.left:
23                    queue.append(node.left)
24                if node.right:
25                    queue.append(node.right)
26            result.append(level)
27
28        return result[::-1]