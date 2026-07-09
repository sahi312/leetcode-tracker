# Last updated: 7/9/2026, 7:46:47 PM
1class Solution:
2    def firstUniqChar(self, s: str) -> int:
3        freq = {}
4
5        for c in s:
6            freq[c] = 1 + freq.get(c, 0)
7        
8        for i, c in enumerate(s):
9            if freq[c] == 1:
10                return i
11        
12        return -1