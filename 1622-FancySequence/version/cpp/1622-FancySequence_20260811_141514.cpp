// Last updated: 8/11/2026, 2:15:14 PM
1class Solution {
2public:
3    vector<int> getBiggestThree(vector<vector<int>>& grid) {
4        int m = grid.size();
5        int n = grid[0].size();
6        set<int> st;
7
8        for(int i=0;i<m;i++){
9            for(int j=0;j<n;j++){
10                st.insert(grid[i][j]);
11
12                for(int k=1;;k++){
13                    if(i-k<0 || i+k>=m || j-k<0 || j+k>=n) break;
14
15                    int sum = 0;
16
17                    int r = i-k;
18                    int c = j;
19                    for(int t=0;t<k;t++) sum += grid[r+t][c+t];
20
21                    r = i;
22                    c = j+k;
23                    for(int t=0;t<k;t++) sum += grid[r+t][c-t];
24
25                    r = i+k;
26                    c = j;
27                    for(int t=0;t<k;t++) sum += grid[r-t][c-t];
28
29                    r = i;
30                    c = j-k;
31                    for(int t=0;t<k;t++) sum += grid[r-t][c+t];
32
33                    st.insert(sum);
34                }
35            }
36        }
37
38        vector<int> ans;
39        auto it = st.rbegin();
40        for(int i=0;i<3 && it!=st.rend();i++,it++) ans.push_back(*it);
41
42        return ans;
43    }
44};