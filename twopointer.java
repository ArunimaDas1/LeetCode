// 26. Remove Duplicates from Sorted Array
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}

// 27. Remove Element
class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

// 977. Squares of a Sorted Array
class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
            k--;
        }
        return ans;
    }
}

// 18. 4Sum
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}

// 16. 3Sum Closest
class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                if (sum == target) return sum;
                else if (sum < target) left++;
                else right--;
            }
        }
        return closest;
    }
}

// 209. Minimum Size Subarray Sum
class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int slow = 0, sum = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                minLen = Math.min(minLen, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

// 392. Is Subsequence
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int p = 0, q = 0;
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) p++;
            q++;
        }
        return p == s.length();
    }
}