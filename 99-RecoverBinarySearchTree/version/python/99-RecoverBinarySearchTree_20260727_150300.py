# Last updated: 7/27/2026, 3:03:00 PM
1class Solution(object):
2    def flatten(self, root):
3        current = root
4
5        while current:
6            if current.left:
7                predecessor = current.left
8                while predecessor.right:
9                    predecessor = predecessor.right
10                predecessor.right = current.right
11                current.right = current.left
12                current.left = None
13            current = current.right