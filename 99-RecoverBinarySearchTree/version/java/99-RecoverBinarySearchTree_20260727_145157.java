// Last updated: 7/27/2026, 2:51:57 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ans = new ArrayList<>();
19
20        if(root == null){
21            return ans;
22        }
23
24        Queue<TreeNode> queue = new LinkedList<>();
25        queue.offer(root);
26
27        while(!queue.isEmpty()) {
28
29            int size = queue.size(); 
30            List<Integer> level = new ArrayList<>();
31
32            for(int i = 0; i < size; i++){
33
34                TreeNode curr = queue.poll();
35                level.add(curr.val);
36
37                if(curr.left != null){
38                    queue.offer(curr.left);
39                }
40
41                if(curr.right != null){
42                    queue.offer(curr.right);
43                }
44            }
45
46            ans.add(level);
47        }
48
49        return ans;
50    }
51}