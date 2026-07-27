// Last updated: 7/27/2026, 3:01:09 PM
1class Solution {
2    public boolean hasPathSum(TreeNode root, int targetSum) {
3        if (root == null) return false;
4        
5        targetSum -= root.val;
6        
7        if (root.left == null && root.right == null) {
8            return targetSum == 0;
9        }
10        
11        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
12    }
13}