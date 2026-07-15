# Last updated: 7/15/2026, 3:02:03 PM
1class Solution:
2    def grayCode(self, n):
3        result = []
4        for i in range(1 << n):
5            result.append(i ^ (i >> 1))
6        return result