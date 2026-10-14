class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        // Base case: if there is only 1 element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // 1. Find max in left half recursively
        int leftMax = divideAndConquer(nums, left, mid);

        // 2. Find max in right half recursively
        int rightMax = divideAndConquer(nums, mid + 1, right);

        // 3. Find max crossing the middle (using your reach logic!)
        int crossMax = maxCrossingSum(nums, left, mid, right);

        // Return the best of the three
        return Math.Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Max left reach (walking backwards from mid)
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += nums[i];
            leftSum = Math.max(leftSum, currentSum);
        }

        // Max right reach (walking forwards from mid + 1)
        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            rightSum = Math.max(rightSum, currentSum);
        }

        // Combine both sides to get the total crossing sum
        return leftSum + rightSum;
    }
}