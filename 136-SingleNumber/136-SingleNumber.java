// Last updated: 7/9/2026, 10:09:09 AM
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;        
    }
}