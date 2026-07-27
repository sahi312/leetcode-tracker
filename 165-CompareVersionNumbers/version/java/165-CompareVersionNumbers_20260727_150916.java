// Last updated: 7/27/2026, 3:09:16 PM
1public class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder result = new StringBuilder();
4        while (columnNumber > 0) {
5            columnNumber--;
6            char c = (char) ('A' + columnNumber % 26);
7            result.insert(0, c);
8            columnNumber /= 26;
9        }
10        return result.toString();
11    }
12}