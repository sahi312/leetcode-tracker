// Last updated: 7/9/2026, 7:46:06 PM
1class Solution {
2public:
3    vector<int> lexicalOrder(int n) {
4        vector<int> v;
5        int count = 1;
6        for (int i = 0; i < n; i++) {
7            v.push_back(count);
8            if (count * 10 <= n) {
9                count *= 10;  // Go deeper (e.g., 1 -> 10)
10            } else {
11                if (count >= n) count /= 10;  // Go up if at the limit
12                count++;
13                while (count % 10 == 0) count /= 10;  // Remove trailing zeros
14            }
15        }
16        return v;
17    }
18};