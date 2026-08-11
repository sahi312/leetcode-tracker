# Last updated: 8/11/2026, 2:22:30 PM
1class Solution:
2    def maxProductPath(self, grid):
3        m, n = len(grid), len(grid[0])
4        MOD = 10**9 + 7
5
6        maxProd = [[0]*n for _ in range(m)]
7        minProd = [[0]*n for _ in range(m)]
8
9        maxProd[0][0] = minProd[0][0] = grid[0][0]
10
11        for i in range(1, m):
12            maxProd[i][0] = minProd[i][0] = maxProd[i-1][0] * grid[i][0]
13
14        for j in range(1, n):
15            maxProd[0][j] = minProd[0][j] = maxProd[0][j-1] * grid[0][j]
16
17        for i in range(1, m):
18            for j in range(1, n):
19                val = grid[i][j]
20
21                candidates = [
22                    maxProd[i-1][j] * val,
23                    minProd[i-1][j] * val,
24                    maxProd[i][j-1] * val,
25                    minProd[i][j-1] * val
26                ]
27
28                maxProd[i][j] = max(candidates)
29                minProd[i][j] = min(candidates)
30
31        ans = maxProd[m-1][n-1]
32        return -1 if ans < 0 else ans % MOD