// Last updated: 7/9/2026, 7:48:53 PM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        long sum = 0, diff = 0;
4
5        for (char c : t.toCharArray()) {
6            sum += c - 'a';
7        }
8
9        for (char c : s.toCharArray()) {
10            diff += c - 'a';
11        }
12
13        return (char) (sum - diff + 'a');
14    }
15}