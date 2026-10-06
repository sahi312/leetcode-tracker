# Last updated: 10/6/2026, 3:28:06 PM
1class Solution:
2    def minAddToMakeValid(self, s: str) -> int:
3        opened = added = 0
4        for ch in s:
5            if ch == "(":
6                opened += 1
7            elif opened:  # close a pending "("
8                opened -= 1
9            else:  # ")" with nothing to close -> add a "("
10                added += 1
11        return added + opened  # still-open "(" need a ")" each
12        