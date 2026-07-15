// Last updated: 7/15/2026, 3:20:29 PM
1class Solution {
2    TreeNode first;
3    TreeNode second;
4    TreeNode prev;
5
6    public void recoverTree(TreeNode root) {
7        helper(root);
8        // Swap the values of the two misplaced nodes
9        int temp = first.val;
10        first.val = second.val;
11        second.val = temp;
12    }
13
14    void helper(TreeNode node) {
15        if (node == null) return;
16
17        // Traverse left subtree
18        helper(node.left);
19
20        // Detect swapped nodes
21        if (prev != null && prev.val > node.val) {
22            if (first == null) {
23                first = prev;
24            }
25            second = node;
26        }
27
28        prev = node;
29
30        // Traverse right subtree
31        helper(node.right);
32    }
33}