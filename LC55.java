class Solution {
    public boolean canJump(int[] nums) {
        // Tracks the furthest index we can possibly reach so far
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our maximum reach, we are stuck
            if (i > maxReach) {
                return false;
            }
            
            // Greedy choice: Update our maximum reach if the current position offers a further jump
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Early exit if we can already reach the end
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}