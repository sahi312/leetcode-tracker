// Last updated: 8/11/2026, 2:18:27 PM
1class Solution {
2public:
3    int numberOfSubmatrices(vector<vector<char>>& grid) {
4        int m = grid.size(), n = grid[0].size();
5        int ans = 0;
6
7        vector<vector<int>> px(m, vector<int>(n, 0));
8        vector<vector<int>> py(m, vector<int>(n, 0));
9
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                px[i][j] = (grid[i][j] == 'X');
13                py[i][j] = (grid[i][j] == 'Y');
14
15                if (i > 0) {
16                    px[i][j] += px[i - 1][j];
17                    py[i][j] += py[i - 1][j];
18                }
19                if (j > 0) {
20                    px[i][j] += px[i][j - 1];
21                    py[i][j] += py[i][j - 1];
22                }
23                if (i > 0 && j > 0) {
24                    px[i][j] -= px[i - 1][j - 1];
25                    py[i][j] -= py[i - 1][j - 1];
26                }
27
28                if (px[i][j] == py[i][j] && px[i][j] > 0) {
29                    ans++;
30                }
31            }
32        }
33
34        return ans;
35    }
36};