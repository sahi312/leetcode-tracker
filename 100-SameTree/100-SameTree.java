// Last updated: 7/9/2026, 10:09:38 AM
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Check left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}