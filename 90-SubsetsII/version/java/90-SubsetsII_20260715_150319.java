// Last updated: 7/15/2026, 3:03:19 PM
1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> subset = new ArrayList<>();
5        Arrays.sort(nums);
6        backtrack(0, nums, subset, res);
7        return res;        
8    }
9
10    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
11        if (i == nums.length) {
12            res.add(new ArrayList<>(subset));
13            return;
14        }
15
16        subset.add(nums[i]);
17        backtrack(i + 1, nums, subset, res);
18        subset.remove(subset.size() - 1);
19
20        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
21            i++;
22        }
23
24        backtrack(i + 1, nums, subset, res);
25    }    
26}