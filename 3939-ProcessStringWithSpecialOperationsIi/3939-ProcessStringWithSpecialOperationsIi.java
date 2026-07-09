// Last updated: 7/9/2026, 10:06:43 AM
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = len[i] * 2;
            } else { // %
                len[i + 1] = len[i];
            }
        }

        if (k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = len[i];

            if (c >= 'a' && c <= 'z') {
                if (k == prevLen) {
                    return c;
                }
            } else if (c == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (c == '%') {
                k = prevLen - 1 - k;
            }
            // '*' needs no change to k
        }

        return '.';
    }
}