// Last updated: 7/11/2026, 4:17:48 PM
1class Solution {
2    public int numDecodings(String s) {
3        int n = s.length();
4        if (n == 1 || s.charAt(0) == '0') {
5            return s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
6        }
7
8        int[] dp = new int[n];
9
10        int d1 = s.charAt(0) - '0';
11        int d2 = s.charAt(1) - '0';
12
13        dp[0] = d1 >= 1 && d1 <= 9 ? 1 : 0;
14
15        dp[1] += d2 >= 1 && d2 <= 9 ? 1 : 0;
16        dp[1] += d1 * 10 + d2 >= 1 && d1 * 10 + d2 <= 26 && d1 != 0 ? 1 : 0;
17
18        for (int i = 2; i < n; i++) {
19            d1 = s.charAt(i - 1) - '0';
20            d2 = s.charAt(i) - '0';
21
22            int num = d1 * 10 + d2;
23
24            int sum = (d2 >= 1 && d2 <= 9 ? dp[i - 1] : 0);
25            sum += (num >= 1 && num <= 26 && d1 != 0 ? dp[i - 2] : 0);
26
27            dp[i] = sum;
28
29            if (dp[i] == 0) return 0;
30        }
31
32        return dp[n - 1];
33    }
34}