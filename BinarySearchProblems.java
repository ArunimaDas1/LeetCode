public class BinarySearchProblems {

    // LC 34: Find First and Last Position of Element in Sorted Array
    static class Solution34 {
        public int[] searchRange(int[] nums, int target) {
            int left = findLeft(nums, target);

            if (left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }

            int right = findRight(nums, target);
            return new int[]{left, right};
        }

        private int findLeft(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int findRight(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low + 1) / 2;
                if (nums[mid] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }

    // LC 35: Search Insert Position
    static class Solution35 {
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    // LC 852: Peak Index in a Mountain Array
    static class Solution852 {
        public int peakIndexInMountainArray(int[] arr) {
            int low = 0;
            int high = arr.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}