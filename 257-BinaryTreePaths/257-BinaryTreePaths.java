// Last updated: 7/9/2026, 10:07:53 AM
class Solution {
    private void paths(TreeNode root, List<String> result, StringBuilder sb) {
        if (root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
        }
        paths(root.left,  result, sb);
        paths(root.right, result, sb);
        sb.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        paths(root, result, new StringBuilder());
        return result;
    }
}