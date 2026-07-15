// Last updated: 7/15/2026, 3:21:11 PM
1class Solution {
2    public boolean isSameTree(TreeNode p, TreeNode q) {
3        // Base case: if both trees are null, they are identical
4        if (p == null && q == null) {
5            return true;
6        }
7        // If only one tree is null or the values are different, they are not identical
8        if (p == null || q == null || p.val != q.val) {
9            return false;
10        }
11        // Recursively check if the left and right subtrees are identical
12        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
13    }
14}