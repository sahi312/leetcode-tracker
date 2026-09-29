// Last updated: 9/29/2026, 4:05:58 PM
1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        if (nums.length == 1) {
5            List<Integer> singleList = new ArrayList<>();
6            singleList.add(nums[0]);
7            res.add(singleList);
8            return res;
9        }
10
11        for (int i = 0; i < nums.length; i++) {
12            int n = nums[i];
13            int[] remainingNums = new int[nums.length - 1];
14            int index = 0;
15            for (int j = 0; j < nums.length; j++) {
16                if (j != i) {
17                    remainingNums[index] = nums[j];
18                    index++;
19                }
20            }
21            
22            List<List<Integer>> perms = permute(remainingNums);
23            for (List<Integer> p : perms) {
24                p.add(n);
25            }
26            
27            res.addAll(perms);
28        }
29        
30        return res;        
31    }
32}