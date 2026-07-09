// Last updated: 7/9/2026, 10:06:10 AM
class Solution {

    public long maxSum(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        long output = -150000000;
        TreeMap<Integer, Integer> candidates = new TreeMap<>(), others = new TreeMap<>();
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            long m = 0;
            // "candidates" stores all the candidate elements in subarray with the max sum. This map starts with the largest k elements, because we can always get these elements into the subarray with at most k operations.
            // "others" stores the rest elements who may become a candidate later on.  
            for (int j = 0; j < nums.length - k; j++)
                others.put(copy[j], others.getOrDefault(copy[j], 0) + 1);
            for (int j = nums.length - k; j < nums.length; j++)
                candidates.put(copy[j], candidates.getOrDefault(copy[j], 0) + 1);
            for (int j = i; j < nums.length; j++) {
                // As we expand the subarray gradually, we need to pull more elements as the candidates.
                // If nums[j] has been a candidates, that means we don't need any operation to pull nums[j] into the candidate map, hence we can just fetch the largest elements in "others" as a new candidate.
                // Otherwise, nums[j] needs to be pulled in as a candidate.
                if (!others.isEmpty()) {
                    int key = others.containsKey(nums[j]) ? nums[j] : others.lastKey(), value = others.get(key);
                    candidates.put(key, candidates.getOrDefault(key, 0) + 1);
                    if (value == 1)
                        others.remove(key);
                    else
                        others.put(key, others.get(key) - 1);
                }
                // In order to achieve the max sum, we always find the max possible value for the current position j.
                m += candidates.lastKey();
                int key = candidates.lastKey(), value = candidates.lastEntry().getValue();
                if (value == 1)
                    candidates.remove(key);
                else
                    candidates.put(key, value - 1);
                output = Math.max(m, output);
            }
            candidates.clear();
            others.clear();
        }
        return output;
    }

}