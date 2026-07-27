// Last updated: 7/27/2026, 12:36:37 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max1 = Integer.MIN_VALUE;
4        int max2 = Integer.MIN_VALUE;
5
6        for(int i : nums){
7            if(i > max1){
8                max2 = max1;
9                max1 = i;
10            }
11            else if(i > max2){
12                max2 = i;
13            }
14        }
15
16        return (max1 - 1) * (max2 - 1);
17    }
18}