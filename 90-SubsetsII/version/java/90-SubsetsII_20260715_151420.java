// Last updated: 7/15/2026, 3:14:20 PM
1
2class Solution {
3    public List<TreeNode> generateTrees(int n) {
4        if (n == 0) {
5            return new ArrayList<>();
6        }
7        
8        Map<String, List<TreeNode>> memo = new HashMap<>();
9
10        return generateTreesHelper(1, n, memo);        
11    }
12
13    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> memo) {
14        String key = start + "-" + end;
15        if (memo.containsKey(key)) {
16            return memo.get(key);
17        }
18        
19        List<TreeNode> trees = new ArrayList<>();
20        if (start > end) {
21            trees.add(null);
22            return trees;
23        }
24        
25        for (int rootVal = start; rootVal <= end; rootVal++) {
26            List<TreeNode> leftTrees = generateTreesHelper(start, rootVal - 1, memo);
27            List<TreeNode> rightTrees = generateTreesHelper(rootVal + 1, end, memo);
28            
29            for (TreeNode leftTree : leftTrees) {
30                for (TreeNode rightTree : rightTrees) {
31                    TreeNode root = new TreeNode(rootVal);
32                    root.left = leftTree;
33                    root.right = rightTree;
34                    trees.add(root);
35                }
36            }
37        }
38        
39        memo.put(key, trees);
40        return trees;
41    }
42}