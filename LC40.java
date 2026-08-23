import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // MUST sort before starting backtracking
        Arrays.sort(candidates); 
        backtrack(0, 0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int sum, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            sum += candidates[i];

            backtrack(i + 1, sum, candidates, target, current, result);

            current.remove(current.size() - 1);
            sum -= candidates[i];
        }
    }
}