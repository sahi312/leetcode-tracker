// Last updated: 7/27/2026, 3:07:43 PM
1class Solution {
2    public String fractionToDecimal(int numerator, int denominator) {
3        if (numerator == 0) return "0";
4
5        StringBuilder result = new StringBuilder();
6        // Handle sign
7        if ((numerator < 0) ^ (denominator < 0)) result.append("-");
8
9        long num = Math.abs((long) numerator);
10        long den = Math.abs((long) denominator);
11
12        // Integer part
13        result.append(num / den);
14        long remainder = num % den;
15        if (remainder == 0) return result.toString();
16
17        // Fractional part
18        result.append(".");
19        Map<Long, Integer> map = new HashMap<>();
20        while (remainder != 0) {
21            if (map.containsKey(remainder)) {
22                int idx = map.get(remainder);
23                result.insert(idx, "(");
24                result.append(")");
25                return result.toString();
26            }
27            map.put(remainder, result.length());
28            remainder *= 10;
29            result.append(remainder / den);
30            remainder %= den;
31        }
32        return result.toString();
33    }
34}