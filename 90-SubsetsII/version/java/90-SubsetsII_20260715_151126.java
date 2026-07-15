// Last updated: 7/15/2026, 3:11:26 PM
1class Solution {
2    public List<Integer> inorderTraversal(TreeNode root) {
3        List<Integer> res = new ArrayList<>();
4        helper(root, res);
5        return res;
6    }
7
8    public void helper(TreeNode root, List<Integer> res) {
9        if (root != null) {
10            helper(root.left, res);
11            res.add(root.val);
12            helper(root.right, res);
13        }
14    }
15}