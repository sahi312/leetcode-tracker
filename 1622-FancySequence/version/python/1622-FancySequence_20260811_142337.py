# Last updated: 8/11/2026, 2:23:37 PM
1class Solution:
2    def constructProductMatrix(self, grid):
3        m, n = len(grid), len(grid[0])
4        arr = [grid[i][j] for i in range(m) for j in range(n)]
5
6        size = len(arr)
7        pre = [1]*size
8        suf = [1]*size
9
10        for i in range(1, size):
11            pre[i] = (pre[i-1] * arr[i-1]) % 12345
12
13        for i in range(size-2, -1, -1):
14            suf[i] = (arr[i+1] * suf[i+1]) % 12345
15
16        res = [(pre[i]*suf[i]) % 12345 for i in range(size)]
17
18        ans = [[0]*n for _ in range(m)]
19        idx = 0
20        for i in range(m):
21            for j in range(n):
22                ans[i][j] = res[idx]
23                idx += 1
24
25        return ans