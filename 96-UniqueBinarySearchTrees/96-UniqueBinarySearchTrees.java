// Last updated: 7/9/2026, 10:09:42 AM
class Solution {
    public int numTrees(int n) {
        int[] uniqTree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uniqTree[i] = 1;
        }

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                total += uniqTree[root - 1] * uniqTree[nodes - root];
            }
            uniqTree[nodes] = total;
        }

        return uniqTree[n];        
    }
}