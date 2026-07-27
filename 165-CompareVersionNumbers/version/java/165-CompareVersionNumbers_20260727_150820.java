// Last updated: 7/27/2026, 3:08:20 PM
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int left = 0;
4        int right = numbers.length - 1;
5
6        while (left < right) {
7            int total = numbers[left] + numbers[right];
8
9            if (total == target) {
10                return new int[]{left + 1, right + 1};
11            } else if (total > target) {
12                right--;
13            } else {
14                left++;
15            }
16        }
17        return new int[]{-1, -1}; // If no solution is found        
18    }
19}