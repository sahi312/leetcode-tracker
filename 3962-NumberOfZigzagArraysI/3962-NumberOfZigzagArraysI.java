// Last updated: 7/9/2026, 10:06:25 AM
class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {

                if (a == b) continue;

                if (a < b)
                    up[b] = (up[b] + 1) % MOD;
                else
                    down[b] = (down[b] + 1) % MOD;
            }
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixUp = new long[m + 1];
            long[] prefixDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] = (prefixUp[i] + up[i]) % MOD;
                prefixDown[i + 1] = (prefixDown[i] + down[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int v = 0; v < m; v++) {

                // sum of down[x] where x < v
                newUp[v] = prefixDown[v];

                // sum of up[x] where x > v
                newDown[v] =
                        (prefixUp[m] - prefixUp[v + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (long x : up) ans = (ans + x) % MOD;
            for (long x : down) ans = (ans + x) % MOD;
            return (int) ans;
        }

        for (long x : up) ans = (ans + x) % MOD;
        for (long x : down) ans = (ans + x) % MOD;

        return (int) ans;
    }
}