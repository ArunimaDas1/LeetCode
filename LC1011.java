class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        
        // left = max weight (minimum possible capacity)
        // right = sum of all weights (maximum possible capacity)
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if we can ship all with capacity = mid in <= days
            if (canShip(weights, days, mid)) {
                right = mid;  // Try smaller capacity
            } else {
                left = mid + 1;  // Need larger capacity
            }
        }
        
        return left;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int daysNeeded = 1;
        
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        
        return daysNeeded <= days;
    }
}