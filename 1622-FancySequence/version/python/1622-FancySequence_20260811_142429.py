# Last updated: 8/11/2026, 2:24:29 PM
1class Solution(object):
2    def canPartitionGrid(self, grid):
3        n = len(grid)
4        m = len(grid[0])
5
6        def checkHz():
7            st = set()
8            pref = 0
9
10            for i in range(n):
11                rowSum = 0
12                for j in range(m):
13                    rowSum += grid[i][j]
14                pref += rowSum
15                st.add(pref)
16
17            if pref % 2 != 0:
18                return False
19
20            return (pref // 2) in st
21
22        def checkVz():
23            st = set()
24            pref = 0
25
26            for j in range(m):
27                colSum = 0
28                for i in range(n):
29                    colSum += grid[i][j]
30                pref += colSum
31                st.add(pref)
32
33            if pref % 2 != 0:
34                return False
35
36            return (pref // 2) in st
37
38        return checkHz() or checkVz()