import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base Case: If the permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Copy current state
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if element is already included in current path
            if (used[i]) continue;

            // 1. MAKE CHOICE
            used[i] = true;
            current.add(nums[i]);

            // 2. EXPLORE
            backtrack(nums, current, used, result);

            // 3. UNDO CHOICE (Backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}