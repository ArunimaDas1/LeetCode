import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, 0, candidates, target, new ArrayList<>(), result);
        Arrays.sort(candidates);
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

            backtrack(i, sum, candidates, target, current, result);

            current.remove(current.size() - 1);
            sum -= candidates[i];
        }
    }
}