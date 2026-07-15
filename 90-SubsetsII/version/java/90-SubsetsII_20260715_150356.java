// Last updated: 7/15/2026, 3:03:56 PM
1public class Solution {
2    public int numDecodings(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6        int n = s.length();
7        int[] dp = new int[n + 1];
8        dp[0] = 1;
9        dp[1] = s.charAt(0) != '0' ? 1 : 0;
10        for (int i = 2; i <= n; i++) {
11            int first = Integer.valueOf(s.substring(i - 1, i));
12            int second = Integer.valueOf(s.substring(i - 2, i));
13            if (first >= 1 && first <= 9) {
14               dp[i] += dp[i-1];  
15            }
16            if (second >= 10 && second <= 26) {
17                dp[i] += dp[i-2];
18            }
19        }
20        return dp[n];
21    }
22}