// Last updated: 8/11/2026, 2:30:32 PM
1class Solution {
2    public String generateString(String S, String t) {
3        char[] s = S.toCharArray();
4        int n = s.length;
5        int m = t.length();
6        char[] ans = new char[n + m - 1];
7        Arrays.fill(ans, '?');
8
9        // Process T
10        int[] z = calcZ(t);
11        int pre = -m;
12        for (int i = 0; i < n; i++) {
13            if (s[i] != 'T') {
14                continue;
15            }
16            int size = Math.max(pre + m - i, 0);
17            // The prefix and suffix of t with length size must be equal
18            if (size > 0 && z[m - size] < size) {
19                return "";
20            }
21            // Positions after size are all '?', so fill in t
22            for (int j = size; j < m; j++) {
23                ans[i + j] = t.charAt(j);
24            }
25            pre = i;
26        }
27
28        // Compute the nearest undecided position <= i
29        int[] preQ = new int[ans.length];
30        pre = -1;
31        for (int i = 0; i < ans.length; i++) {
32            if (ans[i] == '?') {
33                ans[i] = 'a'; // Initial value for undecided positions is a
34                pre = i;
35            }
36            preQ[i] = pre;
37        }
38
39        // Find positions in ans equal to t, using KMP or the Z-function
40        z = calcZ(t + new String(ans));
41
42        // Process F
43        for (int i = 0; i < n; i++) {
44            if (s[i] != 'F') {
45                continue;
46            }
47            // The substring must not equal t
48            if (z[m + i] < m) {
49                continue;
50            }
51            // Find the last undecided position
52            int j = preQ[i + m - 1];
53            if (j < i) { // None exists
54                return "";
55            }
56            ans[j] = 'b';
57            i = j; // Jump directly to j
58        }
59
60        return new String(ans);
61    }
62
63    private int[] calcZ(String S) {
64        char[] s = S.toCharArray();
65        int n = s.length;
66        int[] z = new int[n];
67        int boxL = 0; // Left and right boundaries of the z-box (inclusive)
68        int boxR = 0;
69        for (int i = 1; i < n; i++) {
70            if (i <= boxR) {
71                z[i] = Math.min(z[i - boxL], boxR - i + 1);
72            }
73            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
74                boxL = i;
75                boxR = i + z[i];
76                z[i]++;
77            }
78        }
79        z[0] = n;
80        return z;
81    }
82}