class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Option 1: Land rides first, then Water rides
        int landThenWater = calc(landStartTime, landDuration, waterStartTime, waterDuration);
        
        // Option 2: Water rides first, then Land rides
        int waterThenLand = calc(waterStartTime, waterDuration, landStartTime, landDuration);
        
        // Return the best overall finish time
        return Math.min(landThenWater, waterThenLand);
    }

    private int calc(int[] a1, int[] t1, int[] a2, int[] t2) {
        // Step 1: Find the earliest possible finish time for the first category
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < a1.length; i++) {
            minEnd = Math.min(minEnd, a1[i] + t1[i]);
        }

        // Step 2: Find the minimum completion time after picking the best second-category ride
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < a2.length; j++) {
            int finishTime = Math.max(minEnd, a2[j]) + t2[j];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}