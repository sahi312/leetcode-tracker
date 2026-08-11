# Last updated: 8/11/2026, 2:26:32 PM
1class Solution:
2    class DSU:
3        def __init__(self, n):
4            self.parent = list(range(n))
5            self.rank = [0] * n
6
7        def findPar(self, x):
8            if self.parent[x] != x:
9                self.parent[x] = self.findPar(self.parent[x])
10            return self.parent[x]
11
12        def unite(self, x, y):
13            px = self.findPar(x)
14            py = self.findPar(y)
15
16            if px == py:
17                return
18
19            if self.rank[px] < self.rank[py]:
20                self.parent[px] = py
21            elif self.rank[px] > self.rank[py]:
22                self.parent[py] = px
23            else:
24                self.parent[px] = py
25                self.rank[py] += 1
26
27    def compute(self, word, dp):
28        n = len(word)
29        for i in range(n - 1, -1, -1):
30            for j in range(n - 1, -1, -1):
31                if word[i] == word[j]:
32                    if i + 1 < n and j + 1 < n:
33                        dp[i][j] = 1 + dp[i + 1][j + 1]
34                    else:
35                        dp[i][j] = 1
36                else:
37                    dp[i][j] = 0
38
39    def findTheString(self, lcp):
40        n = len(lcp)
41        dsu = self.DSU(n)
42
43        for i in range(n):
44            if lcp[i][i] != n - i:
45                return ""
46
47        for i in range(n):
48            for j in range(i + 1, n):
49                if lcp[i][j] > 0:
50                    dsu.unite(i, j)
51
52        grp = [''] * n
53        word = ['?'] * n
54        c = ord('a')
55
56        for i in range(n):
57            p = dsu.findPar(i)
58            if grp[p] == '':
59                if c > ord('z'):
60                    return ""
61                grp[p] = chr(c)
62                c += 1
63            word[i] = grp[p]
64
65        for i in range(n):
66            for j in range(n):
67                if lcp[i][j] == 0 and word[i] == word[j]:
68                    return ""
69
70        dp = [[0] * n for _ in range(n)]
71        self.compute(word, dp)
72
73        if dp == lcp:
74            return "".join(word)
75        return ""