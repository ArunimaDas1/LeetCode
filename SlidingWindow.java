// 189. Rotate Array
class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}

// 643. Maximum Average Subarray I
class MaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double result = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            result = Math.max(result, sum);
        }
        return result / k;
    }
}