// Last updated: 9/29/2026, 1:56:40 PM
1class Solution {
2    private char[][] grid;
3    private byte[][][] memo;
4    private int m, n;
5
6    public boolean hasValidPath(char[][] grid) {
7        this.grid = grid;
8        m = grid.length;
9        n = grid[0].length;
10        int length = m + n - 1;
11
12        if (length % 2 != 0 || grid[0][0] != '(' ||
13            grid[m - 1][n - 1] != ')') {
14            return false;
15        }
16
17        // 0: unknown, 1: false, 2: true
18        memo = new byte[m][n][length + 1];
19        return dfs(0, 0, 0);
20    }
21
22    private boolean dfs(int row, int col, int balance) {
23        balance += grid[row][col] == '(' ? 1 : -1;
24        int remaining = (m - 1 - row) + (n - 1 - col);
25
26        if (balance < 0 || balance > remaining) return false;
27        if (row == m - 1 && col == n - 1) return balance == 0;
28
29        if (memo[row][col][balance] != 0) {
30            return memo[row][col][balance] == 2;
31        }
32
33        boolean possible =
34            (row + 1 < m && dfs(row + 1, col, balance)) ||
35            (col + 1 < n && dfs(row, col + 1, balance));
36
37        memo[row][col][balance] = (byte) (possible ? 2 : 1);
38        return possible;
39    }
40}