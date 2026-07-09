// Last updated: 7/9/2026, 10:09:07 AM
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}