import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        Map<Integer, Integer> lastOccurrence = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            firstOccurrence.putIfAbsent(num, i);
            lastOccurrence.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
            
            degree = Math.max(degree, count.get(num));
        }

        int minLength = nums.length;

        // Check all elements that achieve the max degree
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int len = lastOccurrence.get(num) - firstOccurrence.get(num) + 1;
                minLength = Math.min(minLength, len);
            }
        }

        return minLength;
    }
