// Last updated: 7/27/2026, 2:54:20 PM
1class Solution {
2    private Map<Integer, Integer> inorderIndexes = new HashMap<>();
3    private int i_pre;
4
5    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
6        if (start > end || i_pre >= preorder.length)
7            return null;
8
9        TreeNode node = new TreeNode(preorder[i_pre]);
10
11        int i_in = inorderIndexes.get(preorder[i_pre]);
12
13        i_pre++;
14
15        node.left = solve(preorder, inorder, start, i_in - 1);
16        node.right = solve(preorder, inorder, i_in + 1, end);
17
18        return node;
19    }
20
21    public TreeNode buildTree(int[] preorder, int[] inorder) {
22        for (int i = 0; i < inorder.length; i++)
23            inorderIndexes.put(inorder[i], i);
24
25        i_pre = 0;
26
27        return solve(preorder, inorder, 0, inorder.length - 1);
28    }
29}