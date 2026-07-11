// Last updated: 7/11/2026, 4:21:46 PM
1public class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int m = s1.length(), n = s2.length(), l = s3.length();
4        if (m + n != l) return false;
5
6        boolean[] dp = new boolean[n + 1];
7        dp[0] = true;
8
9        for (int j = 1; j <= n; ++j) {
10            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
11        }
12
13        for (int i = 1; i <= m; ++i) {
14            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
15            for (int j = 1; j <= n; ++j) {
16                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
17            }
18        }
19        
20        return dp[n];
21    }
22}