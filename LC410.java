class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        // 1. Establish the search space boundaries
        for (int num : nums) {
            low = Math.max(low, num); // 'low' is the single largest element
            high += num;              // 'high' is the sum of all elements
        }
        
        int result = high;
        
        // 2. Binary search on the maximum subarray sum threshold
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // 3. Check if we can split the array keeping individual sums <= mid
            if (canSplit(nums, mid, k)) {
                result = mid;       // 'mid' works! Save it as a candidate.
                high = mid - 1;     // Try to find a smaller maximum sum (look left)
            } else {
                low = mid + 1;      // 'mid' is too small, we need a larger limit (look right)
            }
        }
        
        return result;
    }
    
    // Greedy simulation helper function
    private boolean canSplit(int[] nums, int maxSumAllowed, int maxSplits) {
        int subarraysUsed = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            // If adding this number breaks our capacity limit...
            if (currentSum + num > maxSumAllowed) {
                subarraysUsed++; // We must open a new subarray
                currentSum = 0;  // Reset the sum for the new subarray
            }
            currentSum += num;
        }
        
        // Valid if total subarrays needed doesn't exceed the target partition limit
        return subarraysUsed <= maxSplits;
    }
}