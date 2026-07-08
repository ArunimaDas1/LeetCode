// LC 560. Subarray Sum Equals K
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// LC 347. Top K Frequent Elements
class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[n + 1];
        for (int i = 0; i <= n; i++) bucket[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int idx = 0;
        for (int j = n; j >= 0 && idx < k; j--) {
            for (int num : bucket[j]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
        return result;
    }
}