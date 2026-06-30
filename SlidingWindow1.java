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

// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) sum += arr[i];
        if ((sum / k) >= threshold) count++;
        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            if ((sum / k) >= threshold) count++;
        }
        return count;
    }
}

// 1004. Max Consecutive Ones III
class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, output = 0, maxFreq = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) maxFreq++;
            while (right - left + 1 - maxFreq > k) {
                if (nums[left] == 1) maxFreq--;
                left++;
            }
            output = Math.max(output, right - left + 1);
        }
        return output;
    }
}