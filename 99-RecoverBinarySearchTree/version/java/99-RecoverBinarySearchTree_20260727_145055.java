// Last updated: 7/27/2026, 2:50:55 PM
1class Solution {
2    public boolean isSymmetric(TreeNode root) {
3        if (root == null) {
4            return true;
5        }
6        return isMirror(root.left, root.right);
7    }
8    
9    private boolean isMirror(TreeNode node1, TreeNode node2) {
10        if (node1 == null && node2 == null) {
11            return true;
12        }
13        if (node1 == null || node2 == null) {
14            return false;
15        }
16        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
17    }
18}