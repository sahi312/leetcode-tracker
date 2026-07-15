// Last updated: 7/15/2026, 3:19:49 PM
1class Solution {
2    public boolean isValidBST(TreeNode root) {
3        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);        
4    }
5
6    private boolean valid(TreeNode node, long minimum, long maximum) {
7        if (node == null) return true;
8
9        if (!(node.val > minimum && node.val < maximum)) return false;
10
11        return valid(node.left, minimum, node.val) && valid(node.right, node.val, maximum);
12    }    
13}