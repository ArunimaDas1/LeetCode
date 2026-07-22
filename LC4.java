class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {
            // Cut point in nums1
            int i = low + (high - low) / 2;
            // Forced cut point in nums2
            int j = halfLen - i;

            // Handle edge cases where cut is at the boundary (0 or length)
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Valid partition condition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total elements are odd, max of left partition is the median
                if ((m + n) % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                // If total elements are even, average of boundary elements
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            } 
            // Too many elements taken from nums1, shift cut left
            else if (maxLeft1 > minRight2) {
                high = i - 1;
            } 
            // Too few elements taken from nums1, shift cut right
            else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}